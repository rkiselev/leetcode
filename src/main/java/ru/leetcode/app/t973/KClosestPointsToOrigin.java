package ru.leetcode.app.t973;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    /**
     * https://leetcode.com/problems/k-closest-points-to-origin/
     * <p>
     * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
     * return the k closest points to the origin (0, 0).
     * <p>
     * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     * <p>
     * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that
     * it is in).
     */
    public static void main(String[] args) {
        Assert.assertArrayEquals(new int[][]{{-2,2}}, new Solution().kClosest(new int[][]{{1,3}, {-2,2}}, 1));
    }

    static class Solution {
        public int[][] kClosest(int[][] points, int k) {
            Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
            for (int[] point : points) {
                q.add(point);
            }
            int[][] result = new int[k][2];
            for (int i = 0; i < k; i++) {
                var item = q.poll();
                result[i][0] = item[0];
                result[i][1] = item[1];
            }
            return result;
        }
    }
}
