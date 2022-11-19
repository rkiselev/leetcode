package ru.leetcode.app.t763;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    /**
     * https://leetcode.com/problems/partition-labels/
     * You are given a string s. We want to partition the string into as many parts as possible so that each letter
     * appears in at most one part.
     *
     * Note that the partition is done so that after concatenating all the parts in order, the resultant string should
     * be s.
     *
     * Return a list of integers representing the size of these parts.
     *
     * Example 1:
     *
     * Input: s = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     * The partition is "ababcbaca", "defegde", "hijhklij".
     * This is a partition so that each letter appears in at most one part.
     * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
     * Example 2:
     *
     * Input: s = "eccbbbbdec"
     * Output: [10]
     */
    public static void main(String[] args) {
        Assert.assertEquals(List.of(9,7,8), new Solution().partitionLabels("ababcbacadefegdehijhklij"));
        Assert.assertEquals(List.of(10), new Solution().partitionLabels("eccbbbbdec"));
    }

    static class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> result = new ArrayList<>();
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), i);
            }
            int size = 0;
            int end = -1;
            for(int i = 0; i< s.length(); i++) {
                int latest = map.get(s.charAt(i));
                size++;
                end = Math.max(end, latest);
                if (end == i) {
                    result.add(size);
                    size = 0;
                }
            }
            return result;
        }
    }
}
