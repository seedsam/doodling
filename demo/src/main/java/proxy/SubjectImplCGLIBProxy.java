package proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class SubjectImplCGLIBProxy implements MethodInterceptor {

    private Object object;// 要代理的对象

    public SubjectImplCGLIBProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy)
        throws Throwable {
        // 添加事务控制
        System.out.println("=========cglib动态代理=========");
        System.out.println("在调用前,我要开始事务");
        Object returnValue = methodProxy.invokeSuper(object, args);
        System.out.println("在调用后,我要提交事务");
        System.out.println("=========cglib动态代理=========");
        return returnValue;
    }

    // 获取代理对象
    public Object getObjectProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

}
