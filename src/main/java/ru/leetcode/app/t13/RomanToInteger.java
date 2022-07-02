package ru.leetcode.app.t13;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RomanToInteger {
    /**
     * https://leetcode.com/problems/roman-to-integer/
     *
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is
     * simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not
     * IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction
     * is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer.
     *
     * Example 1:
     *
     * Input: s = "III"
     * Output: 3
     * Explanation: III = 3.
     * Example 2:
     *
     * Input: s = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 3:
     *
     * Input: s = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    public static void main(String[] args) {
        assertEquals(3, new Solution().romanToInt("III"));
        assertEquals(58, new Solution().romanToInt("LVIII"));
        assertEquals(1994, new Solution().romanToInt("MCMXCIV"));
    }
    static class Solution {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        Map<Character, Character> shrinkable = Map.of(
                'V', 'I',
                'X', 'I',
                'L', 'X',
                'C', 'X',
                'D', 'C',
                'M', 'C'
        );

        public int romanToInt(String s) {
            int index = 1;
            char prev = s.charAt(0);
            int result = map.get(prev);
            while(index < s.length()) {
                char current  = s.charAt(index);
                Integer value = map.get(current);
                if (shrinkable.keySet().contains(current) && prev == shrinkable.get(current)) {
                    int prevValue = map.get(prev);
                    result += (value - 2 * prevValue);
                } else {
                    result += value;
                }
                index++;
                prev = current;
            }

            return result;
        }
    }
}
