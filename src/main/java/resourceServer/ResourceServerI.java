package resourceServer;

/**
 * @author v.chibrikov
 *         <p/>
 *         Пример кода для курса на https://stepic.org/
 *         <p/>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public interface ResourceServerI {

    String getName();

    int getAge();

    void setName(String name);

    void setAge(int age);

}
