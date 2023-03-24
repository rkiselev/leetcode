package ru.leetcode.app.t1466;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    /**
     * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
     * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between
     * two different cities (this network form a tree). Last year, The ministry of transport decided to orient the
     * roads in one direction because they are too narrow.
     * <p>
     * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
     * <p>
     * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
     * <p>
     * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number
     * of edges changed.
     * <p>
     * It's guaranteed that each city can reach city 0 after reorder.
     */
    public static void main(String[] args) {
        assertEquals(0, new Solution().minReorder(6, new int[][]{{1, 0}, {2, 0}}));
        assertEquals(3, new Solution().minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
    }

    static class Solution {
        int result = 0;

        public int minReorder(int n, int[][] connections) {
            Set<Integer> visited = new HashSet<>();
            Map<Integer, List<Integer>> adj = new HashMap<>();
            Set<Item> neibors = new HashSet<>();

            for (var item : connections) {
                neibors.add(new Item(item[0], item[1]));

                var list = adj.get(item[0]);
                if (list == null) {
                    list = new ArrayList<>();
                    adj.put(item[0], list);
                }
                list.add(item[1]);

                list = adj.get(item[1]);
                if (list == null) {
                    list = new ArrayList<>();
                    adj.put(item[1], list);
                }
                list.add(item[0]);
            }
            visited.add(0);
            traverse(adj, neibors, visited, 0);
            return result;
        }

        private void traverse(Map<Integer, List<Integer>> adj, Set<Item> neibors, Set<Integer> visited, int index) {

            var list = adj.get(index);
            for (int item : list) {
                if (visited.contains(item)) continue;
                if (!neibors.contains(new Item(item, index))) result++;
                visited.add(item);
                traverse(adj, neibors, visited, item);
            }
        }
    }

    static class Item {
        private int from;
        private int to;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return from == item.from && to == item.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }

        Item(int from, int to) {
            this.to = to;
            this.from = from;
        }
    }
}
