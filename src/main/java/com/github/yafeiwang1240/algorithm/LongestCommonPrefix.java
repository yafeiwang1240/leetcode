package com.github.yafeiwang1240.algorithm;

/*
    编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = strs[0];
        int length;
        char[] chars = new char[result.length()];
        int index;
        for (int i = 1; i < strs.length; i++) {
            index = 0;
            length = result.length() < strs[i].length() ? result.length() : strs[i].length();
            for (int j = 0; j < length; j++) {
                if (result.charAt(j) == strs[i].charAt(j)) {
                    chars[index++] = result.charAt(j);
                } else {
                    break;
                }
            }
            result = new String(chars, 0, index);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
