package ru.leetcode.app.t22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    static class Solution {

        private List<String> result;

        /**
         * https://leetcode.com/problems/generate-parentheses/
         * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
         *
         * Example 1:
         *
         * Input: n = 3
         * Output: ["((()))","(()())","(())()","()(())","()()()"]
         * Example 2:
         *
         * Input: n = 1
         * Output: ["()"]
         *
         */

        public List<String> generateParenthesis(int n) {
            result = new ArrayList<>();
            addParentheses(n, 1, 0, "(");
            return result;
        }

        private void addParentheses(int n, int openCount, int closeCount,String current) {
            if (openCount == n && closeCount == n) {
                result.add(current);
                return;
            } if(openCount < n){
                addParentheses(n, openCount + 1, closeCount, current + "(");
            } if(closeCount < openCount) {
                addParentheses(n, openCount, closeCount + 1, current + ")");
            }
        }
    }
}
