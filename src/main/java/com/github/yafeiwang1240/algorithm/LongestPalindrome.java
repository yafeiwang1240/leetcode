package com.github.yafeiwang1240.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        List<List<Integer>> array = new ArrayList<>(s.length());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        array.add(list);
        for (int i = 1; i < s.length(); i++) {
            List<Integer> last = array.get(i - 1);
            List<Integer> now = new ArrayList<>();
            now.add(1);
            if (s.charAt(i) == s.charAt(i - 1)) {
                now.add(2);
            }
            for (Integer integer : last) {
                int index = i - 1 - integer;
                if (index < 0) {
                    break;
                }
                if (s.charAt(index) == s.charAt(i)) {
                    now.add(integer + 2);
                }
            }
            array.add(now);
        }
        int index = 0;
        int max = 0;
        for (int i = 0; i < array.size(); i++) {
            List<Integer> lst = array.get(i);
            if (max < lst.get(lst.size() - 1)) {
                index = i;
                max = lst.get(lst.size() - 1);
            }
        }
        return s.substring(index - max + 1, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(LongestPalindrome.longestPalindrome("abbbaaabbb"));
        System.out.println(LongestPalindrome.longestPalindrome("aaaaaaa"));
        System.out.println(LongestPalindrome.longestPalindrome("babad"));
        System.out.println(LongestPalindrome.longestPalindrome("cbbd"));
    }
}
