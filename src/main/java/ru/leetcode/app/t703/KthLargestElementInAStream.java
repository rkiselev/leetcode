package ru.leetcode.app.t703;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class KthLargestElementInAStream {
    /**
     * https://leetcode.com/problems/kth-largest-element-in-a-stream/
     *
     * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the
     * sorted order, not the kth distinct element.
     *
     * Implement KthLargest class:
     *
     * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
     * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest
     * element in the stream.
     */

    public static void main(String[] args) {
        var k = new KthLargest(3, new int[]{4,5,8,2});
        assertEquals(4, k.add(3));
        assertEquals(5, k.add(5));
        assertEquals(5, k.add(10));
        assertEquals(8, k.add(9));
        assertEquals(8, k.add(4));
    }

    static class KthLargest {
        private final PriorityQueue<Integer> q = new PriorityQueue<>();
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i: nums) add(i);

        }

        public int add(int val) {
            if (q.size() < k) {
                q.add(val);
            } else if (q.peek() < val){
                q.poll();
                q.add(val);

            }
            return q.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
