package com.belle.springsecurityjwt.test.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 算法思想：在未排序序列中找到最小（大）元素，
 * 存放到未排序序列的起始位置。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int [] arrays = new int[]{100,123,242,12,42,837,38,90,32,343,21,23};
        System.out.println (Arrays.toString (selectionSort (arrays)));
    }

    public static int[] selectionSort(int[] a){
        for (int i=0; i < a.length-1; i++) {
            int index = i;
            for (int j=i+1; j < a.length; j++) {
                if (a[j]<a[index]){
                    index = j;
                }
            }
            a[i] = a[i]+a[index];
            a[index] = a[i]-a[index];
            a[i] = a[i]-a[index];
        }
        return a;
    }
}
