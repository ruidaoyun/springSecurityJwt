package com.belle.springsecurityjwt.test.algorithm;

import java.util.Arrays;

/**
 * @author: rui.dy
 * @date: 2019/10/8
 * @description:
 */
public class ArrayTest {
    /**
     * 给定一个无重复整数序列和一个目标值，当该序列中任意两个数的和等于目标值，输出这两个数的下标值，每个数不可重复使用。
     * 例：序列nums=[2,7,11,15]，目标值target=9，输出[0,1]。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i=0; i < nums.length; i++) {
            for (int j=i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[]=new int[]{1, 2, 3, 5, 6, 7, 8, 10};
        System.out.println (Arrays.toString (twoSum (nums,11)));
    }
}
