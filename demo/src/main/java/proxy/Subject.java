/*
 * Copyright (c) 2011-2036 International Air Transport Association corp.
 * All Rights Reserved.
 */
package proxy;

// 代理
// 缺陷:如果是final类的话无法继承,final方法的话无法重写,原方法没有实现接口的话无法实现
// 基于代理模式,有静态代理和动态代理两种方式
//   静态代理方式:属于硬编码方式,继承.实现重写方法
//   动态代理:分为JDK动态代理和CGLIB动态代理
//      jdk动态代理方式:implements,只能代理接口,反射    代理类其实继承了Proxy类
//      CGLIB动态代理方式:extends,

// 代理如果使用反射的话是否就能实现带呢?
// 为什么jdk动态代理只能实现接口,而不能继承呢?

public interface Subject {
    String sayHello(String str);
}

class HelloImpl implements Subject {

    /**
     * @param str
     * @return
     * @see proxy.Hello#sayHello(java.lang.String)
     */
    @Override
    public String sayHello(String str) {
        return "HelloImpl: " + str;
    }

}
