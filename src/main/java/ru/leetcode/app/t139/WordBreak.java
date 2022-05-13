package ru.leetcode.app.t139;

import java.util.List;

public class WordBreak {
    /**
     * https://leetcode.com/problems/word-break/
     *
     * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
     * space-separated sequence of one or more dictionary words.
     *
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "leetcode", wordDict = ["leet","code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     *
     * Input: s = "applepenapple", wordDict = ["apple","pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     * Note that you are allowed to reuse a dictionary word.
     * Example 3:
     *
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: false
     */

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean [] dp = new boolean[s.length() + 1];
            dp[s.length()] = true;
            for (int i = s.length() - 1; i > 0; i--) {
                for (String w: wordDict) {
                    if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                        dp[i + w.length()] = dp[i];
                        if(dp[i]) break;
                    }
                }
            }
            return dp[0];
        }
    }
}
