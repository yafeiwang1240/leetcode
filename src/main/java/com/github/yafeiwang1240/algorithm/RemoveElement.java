package com.github.yafeiwang1240.algorithm;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] array = new int[]{2,2,2,2};
        System.out.println(removeElement(array, 2));
        System.out.println(Arrays.toString(array));
    }

    public static int removeElement(int[] nums, int val) {
        int newLen = nums.length;
        int currentIndex = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                currentIndex = i;
                newLen--;
                break;
            }
        }
        for (int nextIndex = currentIndex + 1; nextIndex < nums.length; nextIndex++) {
            if (nums[nextIndex] == val) {
                newLen--;
            } else {
                nums[currentIndex++] = nums[nextIndex];
            }
        }
        return newLen;
    }
}
