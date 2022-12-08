package ru.leetcode.app.t435;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class NonoverlappingIntervals {
    /**
     * https://leetcode.com/problems/non-overlapping-intervals/
     * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of
     * intervals you need to remove to make the rest of the intervals non-overlapping.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1
     * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
     * Example 2:
     *
     * Input: intervals = [[1,2],[1,2],[1,2]]
     * Output: 2
     * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
     * Example 3:
     *
     * Input: intervals = [[1,2],[2,3]]
     * Output: 0
     * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
     */
    public static void main(String[] args) {
        Assert.assertEquals(2, new Solution().eraseOverlapIntervals(new int[][]{{0,2},{1,3}, {2,4},{3,5}, {4,6}}));
        Assert.assertEquals(2, new Solution().eraseOverlapIntervals(new int[][]{{1,100},{11,22}, {1,11},{2,12}}));
        Assert.assertEquals(1, new Solution().eraseOverlapIntervals(new int[][]{{1,2},{2,3}, {3,4},{1,3}}));
        Assert.assertEquals(0, new Solution().eraseOverlapIntervals(new int[][]{{1,2},{2,3},}));
        Assert.assertEquals(2, new Solution().eraseOverlapIntervals(new int[][]{{1,2},{1,2}, {1,2}}));
    }

    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            List<int[]> arr = new ArrayList<>();
            for(int[]v : intervals) arr.add(v);
            arr.sort((a,b) -> Integer.compare(a[0], b[0]));
            var prev = arr.get(0);
            int i = 1;
            int result = 0;
            while(i < arr.size()) {
                if (arr.get(i)[0] < prev[1]) {
                    result++;
                    if (prev[1] > arr.get(i)[1]) {
                        prev = arr.get(i);
                    }
                } else {
                    prev = arr.get(i);
                }
                i++;
            }

            return result;

        }
    }
}
