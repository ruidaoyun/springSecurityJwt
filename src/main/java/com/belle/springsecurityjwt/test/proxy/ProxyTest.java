package com.belle.springsecurityjwt.test.proxy;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Iuser user=new UserImpl ();
        InvocationHandler h=new DynamicProxy (user);
        Iuser proxy =(Iuser) Proxy.newProxyInstance (Iuser.class.getClassLoader (),new Class[]{Iuser.class},h);
        proxy.eat ("苹果");

    }
}
