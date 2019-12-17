package com.github.yafeiwang1240.algorithm;

public class SingleNumber3 {
    public static int[] singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(5 ^ 14);
        System.out.println((5 ^ 14) ^ 5);
        System.out.println((5 ^ 14) ^ 14);
    }
}
