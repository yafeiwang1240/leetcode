package com.github.yafeiwang1240.algorithm;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int[] dup = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (index > 0) {
                if (nums[i] != dup[index - 1]) {
                    dup[index++] = nums[i];
                }
            } else {
                dup[index++] = nums[i];
            }
        }
        for (int i = 0; i < dup.length; i++) {
            nums[i] = dup[i];
        }
        return index;
    }
}
