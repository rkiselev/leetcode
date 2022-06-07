package ru.leetcode.app.t32;

public class LongestValidParentheses {

    public static void main(String[] args) {
        new Solution().longestValidParentheses("(()()");
    }

    static class Solution {
        public int longestValidParentheses(String s) {
            int result = 0;
            char prev = '!';
            int max = 0;
            int open = 0;
            int close = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    if (prev == ')') {
                        if (open != close) {
                            if (close >= open) {
                                max = open * 2;
                                result = Math.max(result, max);
                                open = 0;
                                close = 0;
                            } else {
                                open = close;
                            }

                        }
                    }
                    open++;
                } else {
                    close++;
                    if (close > open) {
                        max = open * 2;
                        result = Math.max(result, max);
                        open = 0;
                        close = 0;
                    }
                }
                prev = s.charAt(i);
            }
            if (close >= open) {
                max = open * 2;
            } else {
                max = close * 2;
                result = Math.max(result, max);
            }
            result = Math.max(result, max);
            return result;
        }
    }
}
