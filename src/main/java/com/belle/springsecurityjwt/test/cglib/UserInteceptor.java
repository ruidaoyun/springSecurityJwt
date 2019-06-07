package com.belle.springsecurityjwt.test.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserInteceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println ("before");
        Object object=methodProxy.invokeSuper (o, objects);
        System.out.println ("after");
        return object;
    }
}
