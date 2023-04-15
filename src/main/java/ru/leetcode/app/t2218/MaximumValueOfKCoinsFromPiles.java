package ru.leetcode.app.t2218;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaximumValueOfKCoinsFromPiles {
    /**
     * https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/description/
     * There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.
     *
     * In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.
     *
     * Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to
     * bottom, and a positive integer k, return the maximum total value of coins you can have in your wallet if you
     * choose exactly k coins optimally.
     */
    public static void main(String[] args) {
        assertEquals(101, new Solution().maxValueOfCoins(List.of(List.of(1,100,3), List.of(7,8,9)), 2));
        assertEquals(706, new Solution().maxValueOfCoins(List.of(
                List.of(100),
                List.of(100),
                List.of(100),
                List.of(100),
                List.of(100),
                List.of(100),
                List.of(1,1,1,1,1,1,700)
        ), 7));
    }

    static class Solution {
        int[][] dp;
        public int maxValueOfCoins(List<List<Integer>> piles, int k) {
            dp = new int[piles.size()][k + 1];
            return dfs(piles, 0, k);
        }

        private int dfs(List<List<Integer>> piles, int pile, int k) {
            if (pile == piles.size()) {
                return 0;
            }
            if (dp[pile][k] != 0) return dp[pile][k];
            dp[pile][k] = dfs(piles, pile + 1, k);
            int cur = 0;
            for (int j = 0;  j < Math.min(k, piles.get(pile).size()); j++) {
                cur += piles.get(pile).get(j);
                dp[pile][k] = Math.max(dp[pile][k], cur + dfs(piles, pile + 1, k - j - 1));
            }
            return dp[pile][k];
        }
    }
}
