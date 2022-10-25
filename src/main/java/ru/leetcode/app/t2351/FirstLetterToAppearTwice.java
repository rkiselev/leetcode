package ru.leetcode.app.t2351;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FirstLetterToAppearTwice {
    /**
     * https://leetcode.com/problems/first-letter-to-appear-twice/
     *
     * Given a string s consisting of lowercase English letters, return the first letter to appear twice.
     *
     * Note:
     *
     * - A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
     * - s will contain at least one letter that appears twice.
     */
    public static void main(String[] args) {
        assertEquals('c', new Solution().repeatedCharacter("abccbaacz"));
        assertEquals('d', new Solution().repeatedCharacter("abcdd"));
    }

    static class Solution {
        public char repeatedCharacter(String s) {
            Map<Character, Integer> map = new HashMap<>();

            for(char c: s.toCharArray()) {
                int count = map.getOrDefault(c, 0) + 1;
                if (count == 2) return c;
                map.put(c, count);
            }
            return 'a';
        }
    }
}
