package ru.leetcode.app.t121;

import org.junit.Assert;

public class BestTimeToBuyAndSellStock {

    /**
     *
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     *
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
     * the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */
    public static void main(String[] args) {
        Assert.assertEquals(5, new int[]{7,1,5,3,6,4});

        Assert.assertEquals(0, new int[]{7,6,4,3,1});
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];

        for (int price : prices) {
            if (profit < price - min) {
                profit = price - min;
            }
            if (min > price) {
                min = price;
            }
        }
        return profit;
    }
}
