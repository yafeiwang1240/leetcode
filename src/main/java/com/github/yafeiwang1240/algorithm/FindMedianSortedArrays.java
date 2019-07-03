package com.github.yafeiwang1240.algorithm;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int count = (len1 + len2) % 2 == 0 ? 2 : 1;
        int mid = (len1 + len2 - 1) / 2;
        int index = 0;
        double result = 0d;
        int sum = 0;
        int i1 = 0; int i2 = 0;
        for(int i = 0; i < len1 + len2; i++) {
            int num = 0;
            if(i2 >= len2) {
                num = nums1[i1++];
            } else if(i1 >= len1) {
                num = nums2[i2++];
            } else if(nums1[i1] > nums2[i2]) {
                num = nums2[i2++];
            } else {
                num = nums1[i1++];
            }
            if(index >= mid) {
                sum++;
                result += num;
            }
            if(sum >= count) {
                break;
            }
            index++;
        }
        return result / count;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
