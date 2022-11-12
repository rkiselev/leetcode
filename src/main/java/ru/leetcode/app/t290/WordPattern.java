package ru.leetcode.app.t290;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    /**
     * https://leetcode.com/problems/word-pattern/
     * Given a pattern and a string s, find if s follows the same pattern.
     *
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty
     * word in s.
     * Example 1:
     *
     * Input: pattern = "abba", s = "dog cat cat dog"
     * Output: true
     * Example 2:
     *
     * Input: pattern = "abba", s = "dog cat cat fish"
     * Output: false
     * Example 3:
     *
     * Input: pattern = "aaaa", s = "dog cat cat dog"
     * Output: false
     */
    public static void main(String[] args) {
        Assert.assertTrue(new Solution().wordPattern("abba", "dog cat cat dog"));
        Assert.assertFalse(new Solution().wordPattern("aaaa", "dog cat cat dog"));
        Assert.assertFalse(new Solution().wordPattern("abba", "dog cat cat fish"));
        Assert.assertTrue(new Solution().wordPattern("abba", "dog cat cat dog"));
    }

    static class Solution {
        public boolean wordPattern(String pattern, String s) {
            if (pattern.length() != s.split(" ").length) return false;
            Map<String, Character> map = new HashMap<>();
            Map<Character, String> chars = new HashMap<>();
            var words = s.split(" ");
            for (int i = 0; i < words.length; i++) {
                char c = pattern.charAt(i);
                if (map.containsKey(words[i]) && map.get(words[i]) != c) {
                    return false;
                }
                if (chars.containsKey(c) && !chars.get(c).equals(words[i])) {
                    return false;
                }
                map.put(words[i], c);
                chars.put(c, words[i]);
            }
            return true;
        }
    }
}
