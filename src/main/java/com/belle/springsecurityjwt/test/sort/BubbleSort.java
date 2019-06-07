package com.belle.springsecurityjwt.test.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 算法思想；从下往上相邻元素比较，如果下面元素小于上面元素，则两元素交换位置，
 * 每次循环可以确定一个最小的元素。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] arrays = new int[]{100,123,242,12,42,837,38,90,32,343,21,23};
        System.out.println (Arrays.toString (bubbleSort (arrays)));
    }

    public static int[] bubbleSort(int[] a){
        for (int i=0; i < a.length; i++) {
            boolean flag = true;
            for (int j=a.length-1; j >i; j--) {
                if (a[j]<a[j-1]){
                    a[j] = a[j]+a[j-1];
                    a[j-1] = a[j]-a[j-1];
                    a[j] = a[j]-a[j-1];
                    flag = false;
                }
            }
            if (flag){
                return a;
            }
        }
        return a;
    }
}
