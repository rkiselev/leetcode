package ru.leetcode.app.t1658;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationstoReduceXtoZero {
    /**
     * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
     */

    public static void main(String[] args) {
        new Solution().minOperations(new int[]{5}, 5);
    }

    static class Solution {

        public int minOperations(int[] nums, int x) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                map.put(sum, i);
                sum += nums[i];
            }
            map.put(sum, n);

            int result = Integer.MAX_VALUE;
            sum = 0;
            for (int r = n - 1; r >= 0; r--) {
                if (map.containsKey(x - sum))
                    result = Math.min(result, n - r - 1 + map.get(x - sum));
                sum += nums[r];
            }

            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }
}
