package ru.leetcode.app.t859;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BuddyStrings {
    /**
     * https://leetcode.com/problems/buddy-strings/description/
     * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to
     * goal, otherwise, return false.
     *
     * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping
     * the characters at s[i] and s[j].
     *
     * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
     * Example 1:
     *
     * Input: s = "ab", goal = "ba"
     * Output: true
     * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
     * Example 2:
     *
     * Input: s = "ab", goal = "ab"
     * Output: false
     * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
     * Example 3:
     *
     * Input: s = "aa", goal = "aa"
     * Output: true
     * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
     */
    public static void main(String[] args) {
        assertTrue(new Solution().buddyStrings("ab", "ba"));
        assertFalse(new Solution().buddyStrings("ab", "ab"));
        assertTrue(new Solution().buddyStrings("aa", "aa"));
        assertFalse(new Solution().buddyStrings("abcaa", "abcbb"));
        assertFalse(new Solution().buddyStrings("abac", "abad"));
    }

    static class Solution {
        public boolean buddyStrings(String s, String goal) {
            if (s.length() != goal.length()) return false;

            if (s.equals(goal)) {
                Set<Character> temp = new HashSet<>();
                for (char c : s.toCharArray()) {
                    temp.add(c);
                }
                return temp.size() < goal.length();
            } else {
                int i = 0;
                while(i < s.length() && s.charAt(i) == goal.charAt(i)) i++;
                int j = i + 1;
                while(j < s.length() && s.charAt(j) == goal.charAt(j)) j++;
                if (j >= s.length()) return false;
                String b = s.substring(0, i) +
                        s.charAt(j) +
                        s.substring(i + 1, j) +
                        s.charAt(i) +
                        s.substring(j + 1);
                return b.equals(goal);
            }

        }
    }
}
