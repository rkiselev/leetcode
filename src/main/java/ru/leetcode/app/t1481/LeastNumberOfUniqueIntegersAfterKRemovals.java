package ru.leetcode.app.t1481;

import org.junit.Assert;

import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    /**
     * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
     *
     * Given an array of integers arr and an integer k. Find the least number of unique integers after removing
     * exactly k elements.
     * Example 1:
     *
     * Input: arr = [5,5,4], k = 1
     * Output: 1
     * Explanation: Remove the single 4, only 5 is left.
     * Example 2:
     * Input: arr = [4,3,1,1,3,3,2], k = 3
     * Output: 2
     * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
     */
    public static void main(String[] args) {
        Assert.assertEquals(1, new Solution().findLeastNumOfUniqueInts(new int[]{4, 5, 4}, 1));
        Assert.assertEquals(2, new Solution().findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }

    static class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int v: arr) map.put(v, map.getOrDefault(v, 0) + 1);
            Queue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>((a,b)->Integer.compare(a.getValue(), b.getValue()));
            for(Map.Entry<Integer, Integer> v: map.entrySet()){
                q.add(v);
            }
            while (k != 0) {
                if (q.peek().getValue() == 1) {
                    q.poll();
                } else {
                    var it = q.peek();
                    q.peek().setValue(it.getValue() - 1);
                }
                k--;
            }
            Set<Integer>result = new HashSet<>();
            while(!q.isEmpty()) {
                result.add(q.poll().getKey());
            }
            return result.size();
        }
    }
}
