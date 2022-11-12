package ru.leetcode.app.t239;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        new Solution().maxSlidingWindow(new int[]{7,2,4}, 2);
        new Solution().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            ArrayDeque<Integer>deque = new ArrayDeque<>();
            List<Integer> result = new ArrayList<>();
            int left = 0;
            int right = 0;
            while(right < nums.length) {
                if (!deque.isEmpty() && left > deque.peekFirst()) {
                    deque.pop();
                }
                while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[right]) {
                    deque.pollFirst();
                }
                deque.add(right);
                if (right >= k - 1) {
                    left++;
                    result.add(deque.peekFirst());
                }
                right++;
            }

            int[] arr = new int[result.size()];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = nums[result.get(i)];
            }
            return arr;
        }
    }
}
