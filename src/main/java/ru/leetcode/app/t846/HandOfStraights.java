package ru.leetcode.app.t846;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HandOfStraights {
    /**
     * https://leetcode.com/problems/hand-of-straights/
     * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size
     * groupSize, and consists of groupSize consecutive cards.
     *
     * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return
     * true if she can rearrange the cards, or false otherwise.
     *
     * Example 1:
     *
     * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
     * Output: true
     * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
     * Example 2:
     *
     * Input: hand = [1,2,3,4,5], groupSize = 4
     * Output: false
     * Explanation: Alice's hand can not be rearranged into groups of 4.
     */
    public static void main(String[] args) {
        Assert.assertTrue(new Solution().isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }

    static class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            if (hand.length % groupSize != 0) return false;
            Map<Integer, Integer> numberToCount = new HashMap<>();
            Queue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(a,b));
            for(int val: hand) {
                numberToCount.put(val, numberToCount.getOrDefault(val, 0) + 1);
            }
            for (int val: numberToCount.keySet()) {
                q.add(val);
            }

            while(!q.isEmpty()) {
                int val = q.peek();
                for(int i = val; i < val + groupSize; i++) {
                    if (!numberToCount.containsKey(i)) {
                        return false;
                    }
                    int count = numberToCount.get(i) - 1;
                    if (count == 0 && i != q.peek()) {
                        return false;
                    } else if (count == 0) {
                        q.poll();
                        numberToCount.remove(i);
                    } else {
                        numberToCount.put(i, count);
                    }
                }
            }

            return true;
        }
    }
}
