package ru.leetcode.app.t1647;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    /**
     * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
     * <p>
     * A string s is called good if there are no two different characters in s that have the same frequency.
     * <p>
     * Given a string s, return the minimum number of characters you need to delete to make s good.
     * <p>
     * The frequency of a character in a string is the number of times it appears in the string. For example, in the
     * string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "aab"
     * Output: 0
     * Explanation: s is already good.
     * Example 2:
     * <p>
     * Input: s = "aaabbbcc"
     * Output: 2
     * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
     * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
     * Example 3:
     * <p>
     * Input: s = "ceabaacb"
     * Output: 2
     * Explanation: You can delete both 'c's resulting in the good string "eabaab".
     * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
     */

    public static void main(String[] args) {
        assertEquals(3, new Solution().minDeletions("aabbcc"));
        assertEquals(0, new Solution().minDeletions("abb"));
        assertEquals(2, new Solution().minDeletions("aaabbbcc"));
        assertEquals(2, new Solution().minDeletions("ceabaacb"));
    }

    static class Solution {
        public int minDeletions(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            var list = map.values().stream()
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
            int count = 0;
            Set<Integer> set = new HashSet<>();
            for (char c : map.keySet()) {
                int freq = map.get(c);
                if (!set.add(freq)) {
                    while (freq > 0 && set.contains(freq)) {
                        freq--;
                        count++;
                    }
                    if (freq > 0) set.add(freq);
                }
            }
            return count;

        }

    }
}
