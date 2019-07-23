package proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import proxy.subject.Subject;
import proxy.subject.SubjectImpl;

public class SubjectImplCGLIBProxy02 implements InvocationHandler {

    // 被代理对象
    private Object target;

    public SubjectImplCGLIBProxy02(Object target) {
        this.target = target;
    }

    /**
     * @param proxy 代理对象
     * @param method 被代理方法
     * @param args 被代理方法参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 添加事务控制
        System.out.println("=========cglib动态代理====implements InvocationHandler=====");
        Object returnValue = method.invoke(target, args);
        System.out.println("=========cglib动态代理====implements InvocationHandler=====");
        return returnValue;
    }

    // 获取代理对象
    public Object getObjectProxy() {
        // 创建增强类,Enhancer功能和Proxy差不多
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类或者接口,也就是传入被代理类的Class对象
        enhancer.setSuperclass(target.getClass());
        // 设置代理类的回调函数,参数类型是Callback
        // MethodInterceptor是其子类,SubjectImplCGLIBProxy是实现类
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public static void main(String[] args) {
        Subject subjectImpl = new SubjectImpl();

//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
//                "C:\\Users\\DELL\\Documents\\GitHub\\learn\\demo\\com\\sun\\proxy");
        Subject subjectCGLIBProxy = (Subject) new SubjectImplCGLIBProxy02(subjectImpl)
                .getObjectProxy();
        subjectCGLIBProxy.sayHello("cglib");

    }

}
