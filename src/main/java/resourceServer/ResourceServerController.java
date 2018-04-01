package resourceServer;

/**
 * @author a.akbashev
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class ResourceServerController implements ResourceServerControllerMBean {
    private final ResourceServerI resourceServer;

    public ResourceServerController(ResourceServerI resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    public String getname() {
        return resourceServer.getName();
    }

    @Override
    public int getage() {
        return resourceServer.getAge();
    }

    @Override
    public void setName(String bla) {
        resourceServer.setName(bla);
    }

    @Override
    public void setAge(int bla) {
        resourceServer.setAge(bla);
    }
}
