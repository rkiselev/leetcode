package ru.leetcode.app.t56;

import org.junit.Assert;

import java.util.*;

public class MergeIntervals {
    /**
     * https://leetcode.com/problems/merge-intervals/submissions/
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
     * and return an array of the non-overlapping intervals that cover all the intervals in the input.
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     */
    public static void main(String[] args) {
        Assert.assertArrayEquals(new int[][]{{1,5}}, new Solution().merge(new int[][]{{1,4},{4,5}}));
        Assert.assertArrayEquals(new int[][]{{1,5}}, new Solution().merge(new int[][]{{1,5},{2,4}}));
        Assert.assertArrayEquals(new int[][]{{1,6},{8,10}, {15,18}}, new Solution().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> semiResult = new ArrayList<>();
            Queue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
            for (int i = 0; i < intervals.length; i++) {
                q.add(intervals[i]);
            }
            int[] current = q.poll();
            while(!q.isEmpty()) {
                var it = q.poll();
                if (current[0] <= it[0] && current[1] >= it[0]) {
                    current[1] = Math.max(it[1], current[1]);
                } else {
                    semiResult.add(current);
                    current = it;
                }
            }
            if (semiResult.isEmpty() || !Arrays.equals(current, semiResult.get(semiResult.size() - 1))) {
                semiResult.add(current);
            }
            int[][] result = new int [semiResult.size()][2];
            for (int i = 0; i < semiResult.size(); i++) {
                result[i][0] = semiResult.get(i)[0];
                result[i][1] = semiResult.get(i)[1];
            }

            return result;

        }
    }
}

