package ru.leetcode.app.t2244;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MinimumRoundsToCompleteAllTasks {
    /**
     * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/
     *
     * You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In
     * each round, you can complete either 2 or 3 tasks of the same difficulty level.
     *
     * Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
     *
     * Example 1:
     *
     * Input: tasks = [2,2,3,3,2,4,4,4,4,4]
     * Output: 4
     * Explanation: To complete all the tasks, a possible plan is:
     * - In the first round, you complete 3 tasks of difficulty level 2.
     * - In the second round, you complete 2 tasks of difficulty level 3.
     * - In the third round, you complete 3 tasks of difficulty level 4.
     * - In the fourth round, you complete 2 tasks of difficulty level 4.
     * It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.
     * Example 2:
     *
     * Input: tasks = [2,3,3]
     * Output: -1
     * Explanation: There is only 1 task of difficulty level 2, but in each round, you can only complete either 2 or 3
     * tasks of the same difficulty level. Hence, you cannot complete all the tasks, and the answer is -1.
     */
    public static void main(String[] args) {
        assertEquals(-1, new Solution().minimumRounds(new int[]{1,2,3}));
        assertEquals(-1, new Solution().minimumRounds(new int[]{1,2,1,2,3}));
        assertEquals(3, new Solution().minimumRounds(new int[]{1,2,1,2,3,3}));
        assertEquals(4, new Solution().minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
    }

    static class Solution {
        public int minimumRounds(int[] tasks) {
            Map<Integer, Integer> taskToCount = new HashMap<>();
            for(int t: tasks) {
                taskToCount.put(t, taskToCount.getOrDefault(t,0) + 1);
            }
            int result = 0;
            for(int v: taskToCount.values()) {
                if (v < 2) return -1;
                result += v / 3;
                if(v % 3 !=0 ) result++;
            }
            return result;
        }
    }
}
