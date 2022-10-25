package ru.leetcode.app.t1249;

import static org.junit.Assert.assertEquals;

public class MinimumRemoveMakeValidParentheses {
    /**
     *
     * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
     *
     *
     * Given a string s of '(' , ')' and lowercase English characters.
     *
     * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the
     * resulting parentheses string is valid and return any valid string.
     *
     * Formally, a parentheses string is valid if and only if:
     *
     * It is the empty string, contains only lowercase characters, or
     * It can be written as AB (A concatenated with B), where A and B are valid strings, or
     * It can be written as (A), where A is a valid string.
     *
     * Example 1:
     *
     * Input: s = "lee(t(c)o)de)"
     * Output: "lee(t(c)o)de"
     * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
     * Example 2:
     *
     * Input: s = "a)b(c)d"
     * Output: "ab(c)d"
     * Example 3:
     *
     * Input: s = "))(("
     * Output: ""
     * Explanation: An empty string is also valid.
     *
     */
    public static void main(String[] args) {
        assertEquals("lee(t(c)o)de", new Solution().minRemoveToMakeValid("lee(t(c)o)de)"));
        assertEquals("ab(c)d", new Solution().minRemoveToMakeValid("a)b(c)d"));
        assertEquals("", new Solution().minRemoveToMakeValid("))(("));
    }

    static class Solution {
        public String minRemoveToMakeValid(String s) {
            StringBuilder result = new StringBuilder();
            int open = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    open++;
                } else if (c == ')') {
                    if (open == 0) continue;
                    open--;
                }
                result.append(c);
            }
            boolean isReversed = false;
            if (open != 0) {
                result.reverse();
                isReversed = true;
            }
            while(open != 0) {
                int start = result.indexOf("(");
                result.replace(start, start + 1, "");
                open--;
            }
            if (isReversed) result.reverse();

            return result.toString();
        }
    }
}
