package com.github.yafeiwang1240.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

    字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 */
public class IntToRoman {

    private static class Roman {
        private Character one;
        private Character five;

        protected Roman(Character one, Character five) {
            this.one = one;
            this.five = five;
        }

        public Character getOne() {
            return one;
        }

        public Character getFive() {
            return five;
        }
    }

    private static List<Roman> roman = new ArrayList<>(4);

    static {
        roman.add(new Roman('I', 'V'));
        roman.add(new Roman('X', 'L'));
        roman.add(new Roman('C', 'D'));
        roman.add(new Roman('M', null));
    }

    public static String intToRoman(int num) {
        char[] chars = new char[15];
        int index = 0;
        int length = 15;
        int current;
        while (num > 0) {
            current = num % 10;
            Roman r = roman.get(index);
            if (current >= 5) {
                if (current == 9) {
                    Roman next = roman.get(index + 1);
                    chars[--length] = next.getOne();
                    chars[--length] = r.getOne();
                } else {
                    for (int i = 0; i < current - 5; i++) {
                        chars[--length] = r.getOne();
                    }
                    chars[--length] = r.getFive();
                }
            } else {
                if (current == 4) {
                    chars[--length] = r.getFive();
                    chars[--length] = r.getOne();
                } else {
                    for (int i = 0; i < current; i++) {
                        chars[--length] = r.getOne();
                    }
                }
            }
            num /= 10;
            index++;
        }
        return new String(chars, length, 15 - length);
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(100));
        System.out.println(intToRoman(1000));
        System.out.println(intToRoman(500));
        System.out.println(intToRoman(1888));
    }
}
