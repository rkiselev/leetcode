package ru.leetcode.app.t1941;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    /**
     * https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
     *
     * Given a string s, return true if s is a good string, or false otherwise.
     *
     * A string s is good if all the characters that appear in s have the same number of occurrences
     * (i.e., the same frequency).
     *
     * Example 1:
     *
     * Input: s = "abacbc"
     * Output: true
     * Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
     * Example 2:
     *
     * Input: s = "aaabb"
     * Output: false
     * Explanation: The characters that appear in s are 'a' and 'b'.
     * 'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
     */
    public static void main(String[] args) {
        Assert.assertTrue(new Solution().areOccurrencesEqual("abacbc"));
        Assert.assertFalse(new Solution().areOccurrencesEqual("aaabb"));
    }

    static class Solution {
        public boolean areOccurrencesEqual(String s) {
            Map<Character,Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            return map.values().stream().distinct().count() == 1;

        }

    }
}
