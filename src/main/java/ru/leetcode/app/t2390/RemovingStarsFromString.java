package ru.leetcode.app.t2390;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class RemovingStarsFromString {
    /**
     * https://leetcode.com/problems/removing-stars-from-a-string/description/
     * You are given a string s, which contains stars *.
     *
     * In one operation, you can:
     *
     * Choose a star in s.
     * Remove the closest non-star character to its left, as well as remove the star itself.
     * Return the string after all stars have been removed.
     *
     * Note:
     *
     * The input will be generated such that the operation is always possible.
     * It can be shown that the resulting string will always be unique.
     */
    public static void main(String[] args) {
        assertEquals("lecoe", new Solution().removeStars("leet**cod*e"));
        assertEquals("", new Solution().removeStars("erase*****"));
    }

    static class Solution {
        public String removeStars(String s) {
            StringBuilder b = new StringBuilder();
            for (char c: s.toCharArray()) {
                if (c == '*') {
                    b.deleteCharAt(b.length() - 1);
                } else {
                    b.append(c);
                }
            }
            return b.toString();
        }
        public String removeStars2(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c: s.toCharArray()) {
                if (c == '*') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            StringBuilder b = new StringBuilder();
            while(!stack.isEmpty()) {
                b.append(stack.pop());
            }
            return b.reverse().toString();
        }
    }
}
