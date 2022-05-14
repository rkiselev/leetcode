package ru.leetcode.app.t743;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class NetworkDelayTime {
    /**
     * https://leetcode.com/problems/network-delay-time/
     *
     * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as
     * directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time
     * it takes for a signal to travel from source to target.
     *
     * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal.
     * If it is impossible for all the n nodes to receive the signal, return -1.
     *
     * Example 1:
     *
     *
     * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
     * Output: 2
     * Example 2:
     *
     * Input: times = [[1,2,1]], n = 2, k = 1
     * Output: 1
     * Example 3:
     *
     * Input: times = [[1,2,1]], n = 2, k = 2
     * Output: -1
     */

    public static void main(String[] args) {
        var ar1 = new int[]{2,1,1};
        var ar2 = new int[]{2,3,1};
        var ar3 = new int[]{3,4,1};
        var ar = new int[][]{ar1,ar2,ar3};
        assertEquals(2, new Solution().networkDelayTime(ar, 4,2));
        ar1 = new int[]{1,2,1};
        ar2 = new int[]{2,3,2};
        ar3 = new int[]{1,3,4};
        ar = new int[][]{ar1,ar2,ar3};
        assertEquals(3, new Solution().networkDelayTime(ar, 3,1));
    }

    static class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            int result = Integer.MIN_VALUE;
            var visited = new HashSet<Integer>();
            Map<Integer, List<Dot>> points = new HashMap<>();
            Queue<Dot> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
            for (int i = 0; i < times.length; i++) {
                if (!points.containsKey(times[i][0])) {
                    points.put(times[i][0], new ArrayList<>());
                }
                points.get(times[i][0]).add(new Dot(times[i][1], times[i][2]));
            }
            queue.add(new Dot(k, 0));
            while(!queue.isEmpty()) {
                var current = queue.poll();
                if (!visited.contains(current.next)) {
                    result = Math.max(result, current.time);
                    visited.add(current.next);
                    for (Dot item: points.getOrDefault(current.next, new ArrayList<>())) {
                        queue.add(new Dot(item.next, item.time + current.time));
                    }
                }
            }

            return visited.size() == n ? result : -1;
        }

        class Dot {
            private int next;
            private int time;

            Dot(int next, int time) {
                this.time = time;
                this.next = next;
            }
        }
    }
}
