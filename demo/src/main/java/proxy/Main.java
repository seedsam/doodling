package proxy;

public class Main {

    public static void main(String[] args) {
        Subject subjectImpl = new SubjectImpl();

        // jdk动态代理
        Subject subjectJDKProxy = (Subject) new SubjectImplJDKProxy(subjectImpl).getObjectProxy();
        subjectJDKProxy.sayHello("jdk");

        // cglib动态代理
        Subject subjectCGLIBProxy = (Subject) new SubjectImplCGLIBProxy(subjectImpl)
                .getObjectProxy();
        subjectCGLIBProxy.sayHello("cglib");

    }
}
