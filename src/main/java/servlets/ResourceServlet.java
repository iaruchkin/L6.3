package servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resourceServer.ResourceServerI;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author a.akbashev
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class ResourceServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger(ResourceServlet.class.getName());
    public static final String PAGE_URL = "/resources";
    private final ResourceServerI resourceServer;

    public ResourceServlet(ResourceServerI resourceServer) {
        this.resourceServer = resourceServer;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        /*При получении POST запроса с параметром path=path_to_resource
        прочитает ресурс TestResource из указанного в параметре файла и
        сохранит ссылку в ResourceService*/

        response.setContentType("text/html;charset=utf-8");

        String path = request.getParameter("path");

        TestResource testResource = (TestResource) ReadXMLFileSAX.readXML(path);

        if (path != null) {
            //todo get info from file
            int age = testResource.getAge();
            String name = testResource.getName();

            resourceServer.setAge(age);
            resourceServer.setName(name);

            logger.info("path: {}", path);
            response.getWriter().println("Path");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
    public void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        /*При получении POST запроса с параметром path=path_to_resource
        прочитает ресурс TestResource из указанного в параметре файла и
        сохранит ссылку в ResourceService*/

        response.setContentType("text/html;charset=utf-8");

        String path = request.getParameter("path");

//        ReadXMLFileSAX.readXML("./data/MySqlResource.xdb")
        if (path != null) {
            TestResource testResource = (TestResource) ReadXMLFileSAX.readXML(path);

            resourceServer.setResource(testResource);

            logger.info("path: {}", path);
            response.getWriter().println("Path");
            response.setStatus(HttpServletResponse.SC_OK);
        }

        response.getWriter().println("Path = "+path);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
