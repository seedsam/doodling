package proxy;

public class SubjectImpl implements Subject {

    @Override
    public String sayHello(String str) {
        return "Hello: " + str;
    }

}
