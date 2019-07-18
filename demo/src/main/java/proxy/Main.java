package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 代理
// 缺陷:如果是final类的话无法继承,final方法的话无法重写,原方法没有实现接口的话无法实现
// 基于代理模式,有静态代理和动态代理两种方式,还有一种就是反射
//   静态代理方式:属于硬编码方式,继承.实现重写方法
//   动态代理:分为JDK动态代理和CGLIB动态代理
//      jdk动态代理方式:implements,只能代理接口,反射    代理类其实继承了Proxy类
//      CGLIB动态代理方式:extends,

// 代理如果使用反射的话是否就能实现代理呢?
// 为什么jdk动态代理只能实现接口,而不能继承呢?

public class Main {

    public static void main(String[] args) {

        Subject subjectProxy = (Subject) InvocationHandlerImpl
                .getInvocationHandlerImpl(new RealSubject());

        String hello = subjectProxy.sayHello("friend");

        System.out.println(hello);
    }
}

// 接口
interface Subject {

    String sayHello(String str);
}

// 接口的实现类
class RealSubject implements Subject {

    @Override
    public String sayHello(String str) {
        return "Hello: " + str;
    }
}

// jdk动态代理类
class InvocationHandlerImpl implements InvocationHandler {

    private Object object; // 要代理的对象

    public InvocationHandlerImpl(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 添加事务控制
        System.out.println("在调用前,我要开始事务");
        Object returnValue = method.invoke(object, args);
        System.out.println("在调用后,我要提交事务");
        return returnValue;
    }

    public static Object getInvocationHandlerImpl(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), new InvocationHandlerImpl(object));
    }

}
