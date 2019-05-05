package com.belle.springsecurityjwt.test.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] arrays = new int[]{100,123,242,12,42,837,38,90,32,343,21,23};
        System.out.println (Arrays.toString (arrays));
        fastSort (arrays,0,arrays.length-1);
    }

    public static void fastSort(int[] arrs,int left ,int right){
        if (left>right){
            return;
        }
        int index = arrs[left];
        int i = left;
        int j = right;
        while (i!=j){
            while (arrs[j]>=index &&i<j){
                j--;
            }
            while (arrs[i]<=index &&i<j){
                i++;
            }
            if (i<j){
                arrs[i] = arrs[i]+arrs[j];
                arrs[j] = arrs[i]-arrs[j];
                arrs[i] = arrs[i]-arrs[j];
            }
        }
        System.out.println (Arrays.toString (arrs));
        arrs[left] = arrs[i];
        arrs[i] = index;
        fastSort (arrs,left,i-1);
        fastSort (arrs,i+1,right);

    }
}
