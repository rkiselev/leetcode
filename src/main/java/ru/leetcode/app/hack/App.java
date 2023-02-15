package ru.leetcode.app.hack;

public class App {
    public static void main(String[] args) {
        new Solution().canCompleteCircuit(new int[]{3,0,3}, new int[]{1,3,2});
    }

    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int result = -1;
            int[] total = new int[gas.length];
            int sumGas = 0;
            int sumCost = 0;
            for(int i = 0; i < gas.length; i++) {
                total[i] = gas[i] - cost[i];
                sumGas += gas[i];
                sumCost += cost[i];
            }
            if (sumGas >= sumCost) {
                int sum = 0;
                result = 0;
                for (int i = 0; i < total.length; i++) {
                    sum+= total[i];
                    if (sum < 0) {
                        sum = 0;
                        result = i + 1;
                    }
                }
            }
            return result;
        }
    }
}
