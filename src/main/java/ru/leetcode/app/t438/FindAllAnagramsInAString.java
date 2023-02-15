package ru.leetcode.app.t438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FindAllAnagramsInAString {
    /**
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/
     *
     * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the
     * answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
     * using all the original letters exactly once.
     *
     * Example 1:
     *
     * Input: s = "cbaebabacd", p = "abc"
     * Output: [0,6]
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     *
     * Input: s = "abab", p = "ab"
     * Output: [0,1,2]
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     */

    public static void main(String[] args) {
        assertEquals(List.of(0,6), new Solution().findAnagrams("cbaebabacd", "abc"));
        assertEquals(List.of(0,1,2), new Solution().findAnagrams("abab", "ab"));
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (p.length() > s.length()) return new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            Map<Character, Integer> pMap = stringToMap(p);
            Map<Character, Integer> sMap = stringToMap(s.substring(0, p.length()));
            if (pMap.equals(sMap)) result.add(0);
            for (int i = 1; i <= s.length() - p.length(); i++) {
                char prev = s.charAt(i - 1);
                int count = sMap.get(prev) - 1;
                if (count == 0) {
                    sMap.remove(prev);
                } else {
                    sMap.put(prev, count);
                }
                char current = s.charAt(i + p.length() - 1);
                sMap.put(current, sMap.getOrDefault(current, 0) + 1);
                if (pMap.equals(sMap)) result.add(i);
            }

            return result;
        }

        private Map<Character, Integer> stringToMap(String s) {
            Map<Character, Integer> result = new HashMap<>();
            for (char c: s.toCharArray()) {
                result.put(c, result.getOrDefault(c, 0) + 1);
            }
            return result;
        }
    }
}

