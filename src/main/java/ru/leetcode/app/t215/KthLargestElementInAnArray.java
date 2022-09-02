package ru.leetcode.app.t215;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class KthLargestElementInAnArray {
    /**
     * https://leetcode.com/problems/kth-largest-element-in-an-array/
     *
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     *
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     * Example 2:
     *
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     */
    public static void main(String[] args) {
        assertEquals(5, new Solution().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        assertEquals(4, new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> q = new PriorityQueue<>();
            for (int item: nums) {
                q.add(item);
                if (q.size() > k) q.poll();
            }
            return q.peek();
        }
    }
}
