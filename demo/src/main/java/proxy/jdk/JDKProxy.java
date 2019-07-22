package proxy.jdk;

import java.lang.reflect.*;

import proxy.subject.Subject;

public final class JDKProxy extends Proxy implements Subject {

    static {
        try {
            JDKProxy.m3 = Class.forName("proxy.Subject").getMethod("sayHello",
                    Class.forName("java.lang.String"));
        } catch (NoSuchMethodException ex) {
            throw new NoSuchMethodError(ex.getMessage());
        } catch (ClassNotFoundException ex2) {
            throw new NoClassDefFoundError(ex2.getMessage());
        }
    }

    /**  */
    private static final long serialVersionUID = 1L;
    private static Method m3;

    public JDKProxy(final InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    public final void sayHello(final String s) {
        try {
            super.h.invoke(this, JDKProxy.m3, new Object[] { s });
        } catch (Error | RuntimeException error) {
            throw error;
        } catch (Throwable t) {
            throw new UndeclaredThrowableException(t);
        }
    }

}
