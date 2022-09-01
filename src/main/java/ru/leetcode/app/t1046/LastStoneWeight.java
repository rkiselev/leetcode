package ru.leetcode.app.t1046;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class LastStoneWeight {
    /**
     * https://leetcode.com/problems/last-stone-weight/
     *
     * You are given an array of integers stones where stones[i] is the weight of the ith stone.
     *
     * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
     * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
     *
     * If x == y, both stones are destroyed, and
     * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
     * At the end of the game, there is at most one stone left.
     *
     * Return the weight of the last remaining stone. If there are no stones left, return 0.
     */
    public static void main(String[] args) {
        assertEquals(1, new Solution().lastStoneWeight(new int[]{2,7,4,1,8,1}));
        assertEquals(0, new Solution().lastStoneWeight(new int[]{2, 2}));
        assertEquals(2, new Solution().lastStoneWeight(new int[]{2}));
    }

    static class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> q = new PriorityQueue<>((a1,a2) -> Integer.compare(a2, a1));
            for (int val : stones) q.add(val);
            while(q.size() > 1) {
                int x = q.poll();
                int y = q.poll();
                int val = x - y;
                if (val != 0) q.add(val);
            }
            return q.size() == 1 ? q.peek(): 0;
        }
    }
}
