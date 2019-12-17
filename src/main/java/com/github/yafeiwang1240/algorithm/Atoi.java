package com.github.yafeiwang1240.algorithm;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class Atoi {

    public static int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else {
                index = i;
                break;
            }
        }
        boolean type = false;
        if (str.charAt(index) == '-') {
            type = true;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        } else if (!(str.charAt(index) >= '0' && str.charAt(index) <= '9')) {
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) == '0' && builder.length() == 0) continue;
            if (builder.length() > 10) break;
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                builder.append(str.charAt(i));
            } else {
                break;
            }
        }
        if (builder.length() <= 0) return 0;
        long result = Long.parseLong(builder.toString());
        if (type) result = -result;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("+91283472332"));
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("20000000000000000000"));
    }

}
