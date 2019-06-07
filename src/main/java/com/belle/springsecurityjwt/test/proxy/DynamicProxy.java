package com.belle.springsecurityjwt.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    private Object object;

    public DynamicProxy(Object object) {
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println ("代理前置内容");
        method.invoke (object,args);
        System.out.println ("代理后置内容");
        return null;
    }
}
