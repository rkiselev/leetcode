package ru.leetcode.app.t134;

import org.junit.Assert;

public class GasStation {
    /**
     * https://leetcode.com/problems/gas-station/
     *
     * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
     *
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its
     * next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
     *
     * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the
     * circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to
     * be unique
     */
    public static void main(String[] args) {
        Assert.assertEquals(-1, new Solution().canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int result = -1;
            for (int i = 0; i < gas.length; i++) {
                if (gas[i] >= cost[i] && traverse(i, gas, cost)) {
                    return i;
                }
            }

            return result;
        }

        private boolean traverse(int start, int[] gas, int[] cost){
            int tank = gas[start] - cost[start];
            int current = start + 1;
            if (current >= gas.length) current = 0;
            while(current != start && tank >= 0) {
                tank += gas[current] - cost[current];
                current++;
                if (current >= gas.length) current = 0;
            }
            return current == start;
        }

        public int canCompleteCircuitOptimal(int[] gas, int[] cost) {
            int result = -1;
            int sumGas = 0;
            int sumCost = 0;
            int[] total = new int[gas.length];
            for (int i = 0; i < gas.length; i++) {
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
