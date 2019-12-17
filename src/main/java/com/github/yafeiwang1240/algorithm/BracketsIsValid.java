package com.github.yafeiwang1240.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
 */
public class BracketsIsValid {

    private static Map<Character, Character> bracket = new HashMap<>(3);

    static {
        bracket.put('}', '{');
        bracket.put(']', '[');
        bracket.put(')', '(');
    }

    public static boolean isValid(String s) {
        if (s == null || s.equals("")) return true;
        char[] chars = new char[s.length()];
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (index < 0) {
                chars[++index] = s.charAt(i);
            } else {
                if (bracket.containsKey(s.charAt(i)) && bracket.get(s.charAt(i)) == chars[index]) {
                    --index;
                } else {
                    chars[++index] = s.charAt(i);
                }
            }
        }
        return index < 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
