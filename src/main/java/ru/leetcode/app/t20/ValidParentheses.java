package ru.leetcode.app.t20;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParentheses {

    /**
     * https://leetcode.com/problems/valid-parentheses/
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input
     * string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     */
    public static void main(String[] args) {
        assertTrue(new Solution().isValid("()"));
        assertTrue(new Solution().isValid("()[]{}"));
        assertFalse(new Solution().isValid("(]"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            List<Character> close = List.of(')','}', ']');
            for(char ch: s.toCharArray()) {
                if (close.contains(ch)) {
                    if (stack.isEmpty() || (!isClose(stack.pop(), ch))) {
                        return false;
                    }
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }

        boolean isClose(char first, char second) {
            switch (first) {
                case '{': return second == '}';
                case '[': return second == ']';
                case '(': return second == ')';
                default: return false;
            }
        }
    }
}
