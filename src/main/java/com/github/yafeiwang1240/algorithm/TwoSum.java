package com.github.yafeiwang1240.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum2(int[] nums, int target) {
        int[] r = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                r[0] = i;
                r[1] = map.get(target - nums[i]);
                if(r[0] == r[1]) {
                    continue;
                }
                break;
            }
        }
        return r;
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <= 0) {
            return null;
        }
        int[] _nums = new int[nums.length];
        cpoyTo(nums, _nums);
        Arrays.sort(_nums);
        int min = 0, max = nums.length - 1;
        while(min < max) {
            if(_nums[min] + _nums[max] < target) {
                min++;
            } else if(_nums[min] + _nums[max] > target) {
                max--;
            } else {
                break;
            }
        }
        // 未找到和为target的组合
        if(min == max) {
            return null;
        }
        int index = 0;
        int[] r = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == _nums[min] || nums[i] == _nums[max]) {
                r[index++] = i;
            }
            if(index > 1) {
                break;
            }
        }
        return r;
    }

    private static void cpoyTo(int[] values, int[] _values) {
        for(int i = 0; i < values.length; i++) {
            _values[i] = values[i];
        }
    }

}
