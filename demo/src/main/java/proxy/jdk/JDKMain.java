package proxy.jdk;

import net.sf.cglib.core.DebuggingClassWriter;
import proxy.cglib.SubjectImplCGLIBProxy;
import proxy.subject.Subject;
import proxy.subject.SubjectImpl;

public class JDKMain {

    public static void main(String[] args) {
        Subject subjectImpl = new SubjectImpl();

        // jdk动态代理
        // 在调用newProxyInstance之前将sun.misc.ProxyGenerator.saveGeneratedFiles系统属性设置为true
        // 生成的代理类将被自动写入磁盘；class文件在\Workspaces\项目名称\com\sun\proxy 路径下
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        Subject subjectJDKProxy = (Subject) new SubjectImplJDKProxy(new SubjectImpl()).getObjectProxy();
//        subjectJDKProxy.sayHello("jdk");

        // cglib动态代理
        // 该设置用于输出cglib动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "C:\\Users\\DELL\\Documents\\GitHub\\learn\\demo\\com\\sun\\proxy");
        Subject subjectCGLIBProxy = (Subject) new SubjectImplCGLIBProxy(subjectImpl)
                .getObjectProxy();
        subjectCGLIBProxy.sayHello("cglib");

    }
}
