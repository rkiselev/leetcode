package ru.leetcode.app.t131;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /**
     * https://leetcode.com/problems/palindrome-partitioning/
     * <p>
     * Given a string s, partition s such that every substring of the partition is a palindrome. Return all
     * possible palindrome partitioning of s.
     * <p>
     * A palindrome string is a string that reads the same backward as forward.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "aab"
     * Output: [["a","a","b"],["aa","b"]]
     * Example 2:
     * <p>
     * Input: s = "a"
     * Output: [["a"]]
     */

    public static void main(String[] args) {
        new Solution().partition("aab");
    }

    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            part(s, ans, new ArrayList<>());
            return ans;
        }

        public void part(String s, List<List<String>> ans, List<String> semiResult) {
            if (s.length() == 0) {
                ans.add(new ArrayList<>(semiResult));
                return;
            }
            for (int i = 1; i <= s.length(); i++) {
                String palin = s.substring(0, i);
                if (isPalindrome(palin)) {
                    semiResult.add(palin);
                    part(s.substring(i), ans, semiResult);
                    semiResult.remove(semiResult.size() - 1);
                }
            }
        }

        public boolean isPalindrome(String str) {
            int l = 0;
            int r = str.length() - 1;
            if (l == r) return true;
            while (l < r) {
                if (str.charAt(l) != str.charAt(r)) return false;
                l++;
                r--;
            }
            return true;
        }
    }
}
