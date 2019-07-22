package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//jdk动态代理类
public class SubjectImplJDKProxy implements InvocationHandler {

    private Object target; // 需要代理的目标对象

    public SubjectImplJDKProxy(Object target) {
        this.target = target;
    }

    /**
     * @param proxy 代理实例
     * @param method 接口中的方法
     * @param args 方法中的参数
     * @return 方法返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 添加事务控制
        System.out.println("=========jdk动态代理=========");
        // 方法的返回值
        Object returnValue = method.invoke(target, args);
        System.out.println("=========jdk动态代理=========");
        return returnValue;
    }

   

}
