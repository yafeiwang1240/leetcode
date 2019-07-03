package com.github.yafeiwang1240.algorithm;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int[][] chars = new int[128][2];
        int maxLength = 0;
        int min = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            if(chars[s.charAt(i)][0] > 0 && min <= chars[s.charAt(i)][1]) {
                maxLength = max(maxLength, i - min);
                min = chars[s.charAt(i)][1] + 1;
            }
            chars[s.charAt(i)][0] += 1;
            chars[s.charAt(i)][1] = i;
        }
        maxLength = max(maxLength, i - min);
        return maxLength;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring(""));
    }
}
