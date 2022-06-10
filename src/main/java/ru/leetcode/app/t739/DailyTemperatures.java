package ru.leetcode.app.t739;

import java.util.Stack;

import static org.junit.Assert.assertArrayEquals;

public class DailyTemperatures {
    /**
     * https://leetcode.com/problems/daily-temperatures/
     *
     * Given an array of integers temperatures represents the daily temperatures, return an array answer such
     * that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
     * If there is no future day for which this is possible, keep answer[i] == 0 instead.
     *
     * Example 1:
     *
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     * Example 2:
     *
     * Input: temperatures = [30,40,50,60]
     * Output: [1,1,1,0]
     * Example 3:
     *
     * Input: temperatures = [30,60,90]
     * Output: [1,1,0]
     */
    public static void main(String[] args) {
        assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, new Solution().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
        assertArrayEquals(new int[]{1,1,1,0}, new Solution().dailyTemperatures(new int[]{30,40,50,60}));
        assertArrayEquals(new int[]{1,1,0}, new Solution().dailyTemperatures(new int[]{30,60,90}));
    }

    static class Solution {
        public int[] dailyTemperatures(int[] temp) {
            if (temp.length == 1) return new int[]{0};
            int[] result = new int[temp.length];
            Stack<Pair> stack = new Stack<>();
            for (int i = 0; i < temp.length; i++) {
                while (!stack.isEmpty() && stack.peek().value < temp[i]) {
                    var item = stack.pop();
                    result[item.index] = i - item.index;
                }
                stack.push(new Pair(temp[i], i));
            }
            return result;
        }

        private class Pair {
            int value;
            int index;
            Pair(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }
    }
}
