package ru.leetcode.app.t57;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    /**
     * https://leetcode.com/problems/insert-interval/
     * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
     * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
     * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
     *
     * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
     * intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
     *
     * Return intervals after the insertion.
     */
    public static void main(String[] args) {
        new Solution().insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        new Solution().insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
    }

    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> result = new ArrayList<>();
            boolean added = false;
            for(int[] v : intervals) {
                if (!added && newInterval[1] < v[0]) {
                    added = true;
                    result.add(newInterval);
                    result.add(v);
                } else if (newInterval[0] > v[1]) {
                    result.add(v);
                } else if (newInterval[1] < v[0]) {
                    result.add(v);
                } else {
                    newInterval[0] = Math.min(newInterval[0], v[0]);
                    newInterval[1] = Math.max(newInterval[1], v[1]);
                }
            }
            if (!added) {
                result.add(newInterval);
            }
            int[][] r = new int[result.size()][2];
            for(int i = 0; i < result.size(); i++) {
                r[i][0] = result.get(i)[0];
                r[i][1] = result.get(i)[1];
            }
            return r;
        }
    }
}
