package proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import proxy.subject.Subject;
import proxy.subject.SubjectImpl;

public class SubjectImplCGLIBProxy01 implements MethodInterceptor {

    private Object object;// 要代理的对象

    public SubjectImplCGLIBProxy01(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy)
        throws Throwable {
        // 添加事务控制
        System.out.println("=========cglib动态代理====implements MethodInterceptor=====");
        Object returnValue = methodProxy.invokeSuper(object, args);
        System.out.println("=========cglib动态代理====implements MethodInterceptor=====");
        return returnValue;
    }

    // 获取代理对象
    public Object getObjectProxy() {
        // 创建增强类,Enhancer功能和Proxy差不多
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类或者接口,也就是传入被代理类的Class对象
        enhancer.setSuperclass(object.getClass());
        // 设置代理类的回调函数,参数类型是Callback
        // MethodInterceptor是其子类,SubjectImplCGLIBProxy是实现类
        enhancer.setCallback(this);
        // 设置回调函数的过滤器,根据不同的方法调用不同的增强实现
        enhancer.setCallbackFilter(null);
        return enhancer.create();
    }

    public static void main(String[] args) {
        Subject subjectImpl = new SubjectImpl();

//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
//                "C:\\Users\\DELL\\Documents\\GitHub\\learn\\demo\\com\\sun\\proxy");
        Subject subjectCGLIBProxy = (Subject) new SubjectImplCGLIBProxy01(subjectImpl)
                .getObjectProxy();
        subjectCGLIBProxy.sayHello("cglib");

    }

}
