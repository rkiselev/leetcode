package ru.leetcode.app.t983;

import static org.junit.Assert.assertEquals;

public class MinimumCostForTickets {
    /**
     * https://leetcode.com/problems/minimum-cost-for-tickets/description/
     * You have planned some train traveling one year in advance. The days of the year in which you will travel are
     * given as an integer array days. Each day is an integer from 1 to 365.
     *
     * Train tickets are sold in three different ways:
     *
     * a 1-day pass is sold for costs[0] dollars,
     * a 7-day pass is sold for costs[1] dollars, and
     * a 30-day pass is sold for costs[2] dollars.
     * The passes allow that many days of consecutive travel.
     *
     * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
     * Return the minimum number of dollars you need to travel every day in the given list of days.
     */
    public static void main(String[] args) {
        assertEquals(11, new Solution().mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
        assertEquals(17, new Solution().mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }

    static class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int[] dayTicket = new int[]{1,7,30};
            int[] dp = new int[days.length];

            return calc(days, costs, 0, dayTicket, dp);
        }

        private int calc(int[] days, int[] costs, int index, int[] dayTicket, int[] dp) {
            if (index == days.length) return 0;
            if (dp[index] != 0) return dp[index];

            dp[index] = Integer.MAX_VALUE;
            for (int i = 0; i < costs.length; i++) {
                int j = index;
                while(j < days.length && days[j] < days[index] + dayTicket[i]) {
                    j++;
                }
                dp[index] = Math.min(dp[index], costs[i] + calc(days, costs, j, dayTicket, dp));
            }
            return dp[index];
        }
    }
}
