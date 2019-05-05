package com.belle.springsecurityjwt.test.cglib;

import net.sf.cglib.proxy.Enhancer;

public class ProxyTest {
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer ();//字节码增强器
        enhancer.setSuperclass (Iuser.class);//设置被代理类为父类
        enhancer.setCallback (new UserInteceptor ());//设置回调
        Iuser user =(Iuser) enhancer.create ();//创建代理实例
        user.eat ("苹果");
    }
}
