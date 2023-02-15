package ru.leetcode.app.t6;

public class ZigzagConversion {
    public static void main(String[] args) {
        new Solution().convert("PAYPALISHIRING", 3);
    }

    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                int inc = 2 * (numRows - 1);
                for (int j = i; j < s.length(); j += inc) {
                    result.append(s.charAt(j));
                    if (i > 0 && i < numRows - 1 &&
                            j + inc - 2 * i < s.length()) {
                        result.append(s.charAt(j + inc - 2 * i));
                    }
                }
            }
            return result.toString();
        }
    }
}
