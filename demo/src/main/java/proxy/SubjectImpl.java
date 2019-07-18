package proxy;

public class SubjectImpl implements Subject {

    @Override
    public void sayHello(String str) {
        System.out.println(str);
    }

}
