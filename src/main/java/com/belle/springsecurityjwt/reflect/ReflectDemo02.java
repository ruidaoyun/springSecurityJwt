package com.belle.springsecurityjwt.reflect;

import java.lang.annotation.Annotation;

public class ReflectDemo02 {
    public static void main(String[] args) {
        Class<Person> cls=Person.class;
        try {
            Person person=cls.newInstance ();
            Annotation[] annotations=cls.getAnnotations ();
            for (Annotation annotation : annotations) {
                System.out.println (annotation.annotationType ());
            }
        } catch (InstantiationException e) {
            e.printStackTrace ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        }

    }
}
