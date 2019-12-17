package com.github.yafeiwang1240.algorithm;

/*
    给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素
    所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

    说明:

    s 可能为空，且只包含从 a-z 的小写字母。
    p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class IsMatch {

    public static boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return true;
        }

        if ((s.equals("") && p.equals("")) || p.equals(".*")) {
            return true;
        }

        return match(s.toCharArray(), p.toCharArray());
    }

    public static boolean match(char[] str, char[] pattern) {

        int lenS = str.length;
        int lenP = pattern.length;

        int i = 0;
        int j = 0;
        while(i < lenS || j < lenP) {

            // 模式串结束
            if(j >= lenP) {
                return false;
            }

            // 字符串结束，判断后续模式串
            if(i >= lenS) {
                if(pattern[j] == '*') {
                    j++;
                    continue;
                }
                if((j < lenP - 1 && pattern[j + 1] == '*')) {
                    j += 2;
                    continue;
                }else if(j >= 2 && pattern[j - 1] == '*' && pattern[j] == pattern[j - 2] && i >= 1 && str[i - 1] == pattern[j]) {
                    j++;
                    continue;
                }
                return false;
            }

            char s = str[i];
            char p = pattern[j];
            if(s == p || p == '.') {
                i++;
                j++;
            }else if(pattern[j] == '*' && str[i] == pattern[j - 1]){
                i++;
            }else if(pattern[j] == '*' && str[i] != pattern[j - 1]){
                j++;
            }else if(j < lenP - 1 && pattern[j + 1] == '*'){
                j += 2;
            }else if(j >= 2 && pattern[j - 1] == '*' && pattern[j] == pattern[j - 2] && i >= 1 && str[i - 1] == pattern[j]) {
                j++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("", ".*"));
    }
}
