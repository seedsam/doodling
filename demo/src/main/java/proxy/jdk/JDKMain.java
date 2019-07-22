package proxy.jdk;

import proxy.subject.Subject;
import proxy.subject.SubjectImpl;

public class JDKMain {

    public static void main(String[] args) {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 原对象
        Subject subjectImpl = new SubjectImpl();
        // 代理对象
        Subject subjectJDKProxy = (Subject) new SubjectImplJDKProxy(subjectImpl).getObjectProxy();
        subjectJDKProxy.sayHello("jdk");

    }
}
