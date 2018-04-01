package resourceServer;

import resources.TestResource;
import sax.ReadXMLFileSAX;

public class ResourceServer implements ResourceServerI {
    private String name;
    private int age;
    private TestResource resource = (TestResource)ReadXMLFileSAX.readXML("./data/MySqlResource.xdb");

    public ResourceServer() {
         name = resource.getName();
         age = resource.getAge();
    }

    public void setResource(TestResource resource){
        this.resource = resource;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

}
