package com.github.yafeiwang1240.algorithm;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2, 4, 3}));
    }
}
