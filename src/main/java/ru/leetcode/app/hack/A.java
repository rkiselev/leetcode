package ru.leetcode.app.hack;

import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        new Solution().insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8} );
        new Solution().insert(new int[][]{{1,3},{6,9}}, new int[]{2,5} );
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervs = new ArrayList<>();
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++ ) {
            if (!inserted && isOverlap(intervals[i], newInterval)) {
                newInterval = merge(intervals[i], newInterval);
                continue;
            }
            if (!inserted && newInterval[1] < intervals[i][0]) {
                intervs.add(newInterval);
                inserted = true;
            }
            intervs.add(intervals[i]);
        }
        if (!inserted) intervs.add(newInterval);
        int[][] result = new int[intervs.size()][2];
        for (int i = 0; i < intervs.size(); i++) {
            result[i][0] = intervs.get(i)[0];
            result[i][1] = intervs.get(i)[1];
        }
        return result;
    }

    private boolean isOverlap(int[] first, int[] second) {
        return (first[0] <= second[0] && second[0] <= first[1]) ||
                (first[0] <= second[1] && second[1] <= first[1]) ||
                (second[0] <= first[0] && first[0] <= second[1]) ||
                (second[0] <= first[1] && first[1] <= second[1]);
    }

    private int[] merge(int[] first, int[]second) {
        var result = new int[2];
        result[0] = Math.min(first[0], second[0]);
        result[1] = Math.max(first[1], second[1]);
        return result;
    }
}
