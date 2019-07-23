/*
 * Copyright (c) 2011-2036 International Air Transport Association corp.
 * All Rights Reserved.
 */
package proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackHelper;

/**
 * 
 *
 * @version Seurat v5.8
 * @author Wei Yanqing, 2019-07-23
 */
public class CallbackFilterClass extends CallbackHelper {

    /**
     * @param superclass
     * @param interfaces
     */
    public CallbackFilterClass(Class superclass, Class[] interfaces) {
        super(superclass, interfaces);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param method
     * @return
     * @see net.sf.cglib.proxy.CallbackHelper#getCallback(java.lang.reflect.Method)
     */
    @Override
    protected Object getCallback(Method method) {
        // TODO Auto-generated method stub
        return null;
    }

}
