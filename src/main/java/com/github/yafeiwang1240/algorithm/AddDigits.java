package com.github.yafeiwang1240.algorithm;

/*
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

示例:

输入: 38
输出: 2
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
    public static int addDigits(int num) {
        if (num > 9) {
            num %= 9;
            return num == 0 ? 9 : num;
        }
        return num;
    }
}
