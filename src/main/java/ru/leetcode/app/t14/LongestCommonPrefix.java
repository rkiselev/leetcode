package ru.leetcode.app.t14;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefix {
    /**
     * https://leetcode.com/problems/longest-common-prefix/
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */

    public static void main(String[] args) {
        assertEquals("fl", new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", new Solution().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder result = new StringBuilder();
            int index = 0;
            int minLength = Arrays.stream(strs).map(String::length).mapToInt(it -> it).min().orElse(-1);
            boolean same = true;
            while(index < minLength && same) {
                same = true;
                for(int i = 1; i < strs.length; i++) {
                    if (strs[0].charAt(index) != strs[i].charAt(index)) {
                        same = false;
                        break;
                    }
                }
                if (same) result.append(strs[0].charAt(index));
                index++;

            }

            return result.toString();
        }
    }
}
