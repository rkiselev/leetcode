package ru.leetcode.app.t678;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesisString {
    /**
     * https://leetcode.com/problems/valid-parenthesis-string/
     *
     * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
     *
     * The following rules define a valid string:
     *
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "(*)"
     * Output: true
     * Example 3:
     *
     * Input: s = "(*))"
     * Output: true
     */
    public static void main(String[] args) {
        assertFalse(new Solution().checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
        assertTrue(new Solution().checkValidString("()"));
        assertTrue(new Solution().checkValidString("(*)"));
        assertTrue(new Solution().checkValidString("(*))"));

    }

    static class Solution {
        public boolean checkValidString(String s) {
            int openMin = 0;
            int openMax = 0;

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == ')' && openMin == 0 && openMax == 0) {
                    return false;
                } else if (c == ')') {
                    if (openMin > 0) openMin--;
                    if (openMax > 0) openMax--;
                } else if (c == '(') {
                    openMax++;
                    openMin++;
                } else {
                    openMax++;
                    if(openMin > 0) openMin--;
                }
            }
            return openMin == 0 || openMax == 0;
        }
    }
}
