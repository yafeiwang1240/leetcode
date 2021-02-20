package com.github.yafeiwang1240.algorithm;

public class NumWays {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶，也可以跳上3级台阶。求该青蛙跳上一个 n (0 <= n <= 100)级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if (n == 0)  return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;
        for (int i = 4; i <= n; i++) {
            nums[i] = nums[i - 3] + nums[i - 2];
            if (nums[i] > 1000000007) {
                nums[i] %= 1000000007;
            }
            nums[i] += nums[i - 1];
        }
        return nums[n] % 1000000007;
    }

    public static void main(String[] args) {

        System.out.println(numWays(100));
    }
}
