package ru.leetcode.app.t322;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CoinChange {
    /**
     * https://leetcode.com/problems/coin-change/
     * <p>
     * You are given an integer array coins representing coins of different denominations and an integer amount
     * representing a total amount of money.
     * <p>
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be
     * made up by any combination of the coins, return -1.
     * <p>
     * You may assume that you have an infinite number of each kind of coin.
     */
    public static void main(String[] args) {
        assertEquals(3, new Solution().coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, new Solution().coinChange(new int[]{3}, 2));
        assertEquals(0, new Solution().coinChange(new int[]{3}, 0));
    }

    static class Solution {

        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] <= amount ? dp[amount] : -1;
        }
    }
}
