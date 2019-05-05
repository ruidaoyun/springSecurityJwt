package com.belle.springsecurityjwt.test.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * 算法思想：将数组中的所有元素依次跟前面已经排好的元素相比较，
 * 如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过为止。
 */
public class InsertionSort {
    public static void main(String[] args) {
        int [] arrays = new int[]{100,123,242,12,42,837,38,90,32,343,21,23};
        System.out.println (Arrays.toString (insertionSort (arrays)));
    }

    public static int[] insertionSort(int[] a){
        for (int i=1; i < a.length; i++) {
            for (int j=i; j >0; j--) {
                if (a[j]<a[j-1]){
                    a[j] = a[j] +a[j-1];
                    a[j-1] = a[j] -a[j-1];
                    a[j] = a[j] -a[j-1];
                }else {
                    break;
                }
            }
        }
        return a;
    }
}
