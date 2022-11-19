package ru.leetcode.app.t1296;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DivideArrayInSetsOfKConsecutiveNumbers {
    /**
     * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
     *
     * Given an array of integers nums and a positive integer k, check whether it is possible to divide this array
     * into sets of k consecutive numbers.
     *
     * Return true if it is possible. Otherwise, return false.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,3,4,4,5,6], k = 4
     * Output: true
     * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
     * Example 2:
     *
     * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
     * Output: true
     * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
     * Example 3:
     *
     * Input: nums = [1,2,3,4], k = 3
     * Output: false
     * Explanation: Each array should be divided in subarrays of size 3.
     */

    public static void main(String[] args) {
        assertTrue(new Solution().isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3));
        assertTrue(new Solution().isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
        assertFalse(new Solution().isPossibleDivide(new int[]{1,2,3,3,4,4,5}, 4));
        assertFalse(new Solution().isPossibleDivide(new int[]{1,2,3,3,4,4,5,7}, 4));
    }

    static class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {
            if (nums.length % k != 0) return false;
            Map<Integer,Integer> map = new HashMap<>();
            for(int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
            Queue<Integer> q = new PriorityQueue<>(Integer::compare);
            for(int num: map.keySet()) q.add(num);
            while(!q.isEmpty()) {
                int val = q.peek();
                for(int i = val; i < val + k; i++) {
                    if (map.containsKey(i)) {
                        int count = map.get(i) - 1;
                        if (count == 0 && q.peek() != i) {
                            return false;
                        } else if (count == 0) {
                            q.poll();
                            map.remove(i);
                        } else {
                            map.put(i, count);
                        }
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
