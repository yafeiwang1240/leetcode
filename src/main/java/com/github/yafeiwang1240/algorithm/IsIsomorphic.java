package com.github.yafeiwang1240.algorithm;

import java.util.HashMap;

public class IsIsomorphic {

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> tag = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (tag.containsKey(s.charAt(i))) {
                if (!tag.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            } else {
                tag.put(s.charAt(i), t.charAt(i));
            }
        }
        tag.clear();
        for (int i = 0; i < s.length(); i++) {
            if (tag.containsKey(t.charAt(i))) {
                if (!tag.get(t.charAt(i)).equals(s.charAt(i))) {
                    return false;
                }
            } else {
                tag.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
