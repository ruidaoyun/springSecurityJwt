package com.belle.springsecurityjwt.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    //比较两个整型有序集合的每个值是否相等
    private static boolean compare(List<Integer> list1, List<Integer> list2){
        for (int k=0; k < list1.size(); k++) {
            //System.err.println ("list1 "+list1+"    "+"list2 "+list2);
            if (list1.get (k).intValue ()!=list2.get (k).intValue ()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1=new ArrayList<> ();
        ArrayList<Integer> list2=new ArrayList<> ();
        list1.add (4898);
        list2.add (4898);
        System.out.println (compare (list1, list2));
    }
}
