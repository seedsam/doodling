package proxy;

public class Main {

    public static void main(String[] args) {
        Subject subjectImpl = new SubjectImpl();

        // 在调用newProxyInstance之前将sun.misc.ProxyGenerator.saveGeneratedFiles系统属性设置为true
        // 生成的代理类将被自动写入磁盘；class文件在\Workspaces\项目名称\com\sun\proxy 路径下
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        
        // jdk动态代理
        Subject subjectJDKProxy = (Subject) new SubjectImplJDKProxy(subjectImpl).getObjectProxy();
        subjectJDKProxy.sayHello("jdk");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        // cglib动态代理
        Subject subjectCGLIBProxy = (Subject) new SubjectImplCGLIBProxy(subjectImpl)
                .getObjectProxy();
        subjectCGLIBProxy.sayHello("cglib");

    }
}
