package com.github.yafeiwang1240.algorithm;

/**
 * 数字转大写
 * @author wangyafei
 */
public class ChineseNumeral {

    public static void main(String[] args) {
        System.out.println(toChineseNumeral(1000));
    }

    private static final String[] NUMERAL = {"万", "仟", "佰", "拾"};
    private static final String[] CHINESE_NUMERAL = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final int BIG = 10000;

    /**
     * 数字转大写
     * @param num 0 < num < 100000
     * @return
     */
    public static String toChineseNumeral(int num) {
        if (num == 0) return CHINESE_NUMERAL[0];
        int start = BIG;
        int last = -1;
        int index = 0;
        StringBuilder builder = new StringBuilder();
        int n = num;
        while (n > 0) {
            int mul = n / start;
            if (mul != 0) {
                if (last == 0 && builder.length() != 0) {
                    builder.append(CHINESE_NUMERAL[0]);
                }
                builder.append(CHINESE_NUMERAL[mul]);
                if (index < NUMERAL.length) {
                    builder.append(NUMERAL[index]);
                }
            }
            index++;
            last = mul;
            n %= start;
            start /= 10;
        }
        return builder.toString();
    }
}
