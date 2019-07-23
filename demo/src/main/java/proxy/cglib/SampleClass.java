/*
 * Copyright (c) 2011-2036 International Air Transport Association corp.
 * All Rights Reserved.
 */
package proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.NoOp;

/**
 * 
 *
 * @version Seurat v5.8
 * @author Wei Yanqing, 2019-07-22
 */
public class SampleClass {

    public String test(String input) {
        return "hello world";
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class
                        && method.getReturnType() == String.class) {
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "hello cglib";
                        }
                    };
                } else {
                    return NoOp.INSTANCE;
                }
            }
        };

        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null));
        System.out.println(proxy.toString());

    }

}
