package proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import proxy.subject.Subject;
import proxy.subject.SubjectImpl;

public class Main {

    public static void main(String[] args) {
        Subject subjectImpl = new SubjectImpl();

//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
//                "C:\\Users\\DELL\\Documents\\GitHub\\learn\\demo\\com\\sun\\proxy");
        Subject subjectCGLIBProxy = (Subject) new SubjectImplCGLIBProxy(subjectImpl)
                .getObjectProxy();
        subjectCGLIBProxy.sayHello("cglib");

    }
}
