package ru.leetcode.app.t2405;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class OptimalPartitionOfString {
    /**
     * https://leetcode.com/problems/optimal-partition-of-string/
     * Given a string s, partition the string into one or more substrings such that the characters in each substring
     * are unique. That is, no letter appears in a single substring more than once.
     *
     * Return the minimum number of substrings in such a partition.
     *
     * Note that each character should belong to exactly one substring in a partition.
     *
     * Example 1:
     *
     * Input: s = "abacaba"
     * Output: 4
     * Explanation:
     * Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
     * It can be shown that 4 is the minimum number of substrings needed.
     * Example 2:
     *
     * Input: s = "ssssss"
     * Output: 6
     * Explanation:
     * The only valid partition is ("s","s","s","s","s","s").
     */
    public static void main(String[] args) {
        assertEquals(6, new Solution().partitionString("ssssss"));
        assertEquals(4, new Solution().partitionString("abacaba"));
    }
    static class Solution {
        public int partitionString(String s) {
            Set<Character> current = new HashSet<>();
            int result = 1;
            for (char c: s.toCharArray()) {
                if (current.contains(c)) {
                    current = new HashSet<>();
                    result++;
                }
                current.add(c);
            }
            return result;
        }
    }
}
