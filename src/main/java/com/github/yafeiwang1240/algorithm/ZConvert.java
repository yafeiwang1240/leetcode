package com.github.yafeiwang1240.algorithm;

/**
 * z变形
 */
public class ZConvert {

    public static String convert(String s, int numRows) {
        char[][] chars = new char[numRows][length(s, numRows)];
        return null;
    }

    protected static int length(String s, int numRows) {
        int base = numRows + numRows - 2;
        int baseLength = numRows - 1;
        int first = s.length() / numRows;
        int next = s.length() % numRows;
        if (next > 0 &&  next <= numRows) {
            first++;
        } else {
            first += next - numRows + 1;
        }
        return first;
    }

    public static void main(String[] args) {

    }
}
