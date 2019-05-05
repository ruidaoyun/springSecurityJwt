package com.belle.springsecurityjwt.reflect;

@AnnotationTest
public class Person implements PersonInterface{

    private int count;

    public String name;

    String password;


    @Override
    public void interfaceMethod() {
        System.out.println ("interface method");
    }

    private static void staticMethod(){
        System.out.println ("static method");
    }
}
