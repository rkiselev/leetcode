package ru.leetcode.app.t2492;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MinimumScorePathBetweenTwoCities {
    /**
     * https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
     * You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array
     * roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi
     * with a distance equal to distancei. The cities graph is not necessarily connected.
     *
     * The score of a path between two cities is defined as the minimum distance of a road in this path.
     *
     * Return the minimum possible score of a path between cities 1 and n.
     *
     * Note:
     *
     * A path is a sequence of roads between two cities.
     * It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times
     * along the path.
     * The test cases are generated such that there is at least one path between 1 and n.
     */
    public static void main(String[] args) {
        assertEquals(5, new Solution().minScore(4, new int[][]{{1,2,9}, {2,3,6},{2,4,5}, {1,4,7}}));
        assertEquals(2, new Solution().minScore(4, new int[][]{{1,2,2}, {1,3,4},{3,4,7}}));
    }

    static class Solution {
        int min = Integer.MAX_VALUE;
        public int minScore(int n, int[][] roads) {
            Map<Integer, List<Pair>> adj = new HashMap<>();
            for (int i = 0; i < roads.length; i++) {
                var list = adj.computeIfAbsent(roads[i][0], k -> new ArrayList<>());
                list.add(new Pair(roads[i][1], roads[i][2]));

                list = adj.computeIfAbsent(roads[i][1], k -> new ArrayList<>());
                list.add(new Pair(roads[i][0], roads[i][2]));
            }
            dfs(1, new HashSet<>(), adj);
            return min;
        }

        private void dfs(int index, Set<Integer> visited, Map<Integer,List<Pair>> map) {
            if (visited.contains(index)) return;
            visited.add(index);
            for (Pair pair: map.get(index)) {
                min = Math.min(min, pair.right);
                dfs(pair.left, visited, map);
            }
        }

        class Pair {
            int left;
            int right;

            Pair(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }
    }
}
