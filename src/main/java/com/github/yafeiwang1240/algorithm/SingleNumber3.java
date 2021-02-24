package com.github.yafeiwang1240.algorithm;

import java.util.HashMap;

/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。

进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？


示例 1：

输入：nums = [1,2,1,3,2,5]
输出：[3,5]
解释：[5, 3] 也是有效的答案。
 */
public class SingleNumber3 {
    public static int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length / 2 + 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], nums[i]);
            }
        }
        int[] result = new int[map.size()];
        Object[] objects = map.values().toArray();
        for (int i = 0; i < objects.length; i++) {
            result[i] = (int) objects[i];
        }
        return result;
    }

    public static int[] singleNumber0(int[] nums) {
        int split = 0;
        for (int i = 0; i < nums.length; i++) {
            split ^= nums[i];
        }
        int index = 1;
        while ((index & split) == 0) {
            index <<= 1;
        }
        int result1 = 0, result2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & index) > 0) {
                result1 ^= nums[i];
            } else {
                result2 ^= nums[i];
            }
        }
        return new int[]{result1, result2};
    }

    public static void main(String[] args) {
        System.out.println(singleNumber0(new int[]{1,2,1,3,2,5}));
    }
}
