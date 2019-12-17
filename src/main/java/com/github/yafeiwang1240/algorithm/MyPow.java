package com.github.yafeiwang1240.algorithm;

/*
    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class MyPow {

    public static double myPow(double x, int n) {
        double result = 1;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                result *= x;
            }
            x *= x;
        }
        return n < 0 ? 1.0 / result : result;
    }
}
