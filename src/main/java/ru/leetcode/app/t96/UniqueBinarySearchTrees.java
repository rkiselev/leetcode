package ru.leetcode.app.t96;

import static org.junit.Assert.assertEquals;

public class UniqueBinarySearchTrees {
    /**
     * https://leetcode.com/problems/unique-binary-search-trees/
     * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly
     * n nodes of unique values from 1 to n.
     */

    public static void main(String[] args) {
        assertEquals(1, new Solution().numTrees(1));
        assertEquals(5, new Solution().numTrees(3));
        assertEquals(2, new Solution().numTrees(2));
    }

    static class Solution {
        public int numTrees(int n) {
            int[] result = new int[n + 1];
            result[0] = 1;
            result[1] = 1;
            for (int nodes = 2; nodes <= n; nodes++) {
                int total = 0;
                for (int root = 1; root <= nodes; root++) {
                    int left = root - 1;
                    int right = nodes - root;
                    total += result[left] * result[right];
                }
                result[nodes] = total;
            }
            return result[n];
        }
    }
}
