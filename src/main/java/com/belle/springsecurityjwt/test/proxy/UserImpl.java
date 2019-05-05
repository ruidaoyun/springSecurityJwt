package com.belle.springsecurityjwt.test.proxy;

public class UserImpl implements Iuser{

    @Override
    public void eat(String food) {
        System.out.println ("我要吃"+food);
    }
}
