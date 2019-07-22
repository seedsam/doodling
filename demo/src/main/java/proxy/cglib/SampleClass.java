/*
 * Copyright (c) 2011-2036 International Air Transport Association corp.
 * All Rights Reserved.
 */
package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

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
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {

            @Override
            public Object loadObject() throws Exception {
                return "hello cglib";
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null));
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        System.out.println(proxy.hashCode());

    }

}
