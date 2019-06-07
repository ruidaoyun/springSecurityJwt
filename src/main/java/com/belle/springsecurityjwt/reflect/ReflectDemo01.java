package com.belle.springsecurityjwt.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo01 {
    public static void main(String[] args) {
        Class<Person> cls=Person.class;

        /*Method[] methods=cls.getMethods ();
        for (Method method : methods) {
            System.out.println (method);
        }*/

        Method[] declaredMethods=cls.getDeclaredMethods ();
        for (Method declaredMethod : declaredMethods) {
            //System.out.println (declaredMethod);
            try {
                declaredMethod.setAccessible (true);
                declaredMethod.invoke (cls.newInstance ());
            } catch (IllegalAccessException e) {
                e.printStackTrace ();
            } catch (InvocationTargetException e) {
                e.printStackTrace ();
            } catch (InstantiationException e) {
                e.printStackTrace ();
            }
        }

    }
}
