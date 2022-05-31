package ru.leetcode.app.t424;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LongestRepeatingCharacterReplacement {
    /**
     * https://leetcode.com/problems/longest-repeating-character-replacement/
     *
     * You are given a string s and an integer k. You can choose any character of the string and change it to any
     * other uppercase English character. You can perform this operation at most k times.
     *
     * Return the length of the longest substring containing the same letter you can get after performing the above
     * operations.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
     * Example 2:
     *
     * Input: s = "AABABBA", k = 1
     * Output: 4
     * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     * The substring "BBBB" has the longest repeating letters, which is 4.
     */

    public static void main(String[] args) {
        assertEquals(3, new Solution().characterReplacement("aaab", 0));
        assertEquals(4, new Solution().characterReplacement("aababba", 1));
        assertEquals(4, new Solution().characterReplacement("ABAB", 2));
    }
    static class Solution {
        public int characterReplacement(String s, int k) {
            var map = new HashMap<Character, Integer>();
            int result = 0;
            int start = 0;
            int end = 0;
            while(end < s.length()) {
                char current = s.charAt(end);
                map.put(current, map.getOrDefault(current, 0) + 1);
                int max = map.values().stream().mapToInt(it -> it).max().orElse(0);
                int length = end - start + 1;
                int replace = length - max;
                while(replace > k) {
                    char remove = s.charAt(start);
                    map.put(remove, map.get(remove) - 1);
                    start++;
                    max = map.values().stream().mapToInt(it -> it).max().orElse(0);
                    length = end - start + 1;
                    replace = length - max;
                }
                result = Math.max(result, length);
                end++;
            }
            return result;
        }
    }
}
