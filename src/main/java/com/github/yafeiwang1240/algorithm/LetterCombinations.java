package com.github.yafeiwang1240.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {

    private static List<char[]> list = new ArrayList<>(8);

    static {
        list.add(new char[]{'a', 'b', 'c'});
        list.add(new char[]{'d', 'e', 'f'});
        list.add(new char[]{'g', 'h', 'i'});
        list.add(new char[]{'j', 'k', 'l'});
        list.add(new char[]{'m', 'n', 'o'});
        list.add(new char[]{'p', 'q', 'r', 's'});
        list.add(new char[]{'t', 'u', 'v'});
        list.add(new char[]{'w', 'x', 'y', 'z'});
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        return result;
    }

}
