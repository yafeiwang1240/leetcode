package com.github.yafeiwang1240.algorithm;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 */
public class Reverse {

    public static int reverse(int x) {
        long result = 0;
        int _x = x > 0 ? x : -x;
        while (_x > 0) {
            result = result * 10 + _x % 10;
            _x /= 10;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) (x > 0 ? result : -result);
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }
}
