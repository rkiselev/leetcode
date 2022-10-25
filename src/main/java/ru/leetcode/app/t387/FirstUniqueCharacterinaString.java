package ru.leetcode.app.t387;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FirstUniqueCharacterinaString {
    /**
     * https://leetcode.com/problems/first-unique-character-in-a-string/
     * Given a string s, find the first non-repeating character in it and return its index. If it does not exist,
     * return -1.
     *
     * Example 1:
     *
     * Input: s = "leetcode"
     * Output: 0
     * Example 2:
     *
     * Input: s = "loveleetcode"
     * Output: 2
     * Example 3:
     *
     * Input: s = "aabb"
     * Output: -1
     *
     */
    public static void main(String[] args) {
        assertEquals(0, new Solution().firstUniqChar("leetcode"));
        assertEquals(-1, new Solution().firstUniqChar("abab"));
    }

    static class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer>map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) return i;
            }
            return -1;
        }
    }
}
