package ru.leetcode.app.t621;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TaskScheduler {
    /**
     * https://leetcode.com/problems/task-scheduler/
     *
     * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a
     * different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of
     * time, the CPU could complete either one task or just be idle.
     *
     * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same
     * letter in the array), that is that there must be at least n units of time between any two same tasks.
     *
     * Return the least number of units of times that the CPU will take to finish all the given tasks.
     *
     *
     *
     * Example 1:
     *
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     * Output: 8
     * Explanation:
     * A -> B -> idle -> A -> B -> idle -> A -> B
     * There is at least 2 units of time between any two same tasks.
     * Example 2:
     *
     * Input: tasks = ["A","A","A","B","B","B"], n = 0
     * Output: 6
     * Explanation: On this case any permutation of size 6 would work since n = 0.
     * ["A","A","A","B","B","B"]
     * ["A","B","A","B","A","B"]
     * ["B","B","B","A","A","A"]
     * ...
     * And so on.
     * Example 3:
     *
     * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
     * Output: 16
     * Explanation:
     * One possible solution is
     * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
     */
    public static void main(String[] args) {
        assertEquals(8, new Solution().leastInterval(new char[]{'A','A','A','B','B','B'},2));
        assertEquals(16, new Solution().leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2));
    }

    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            int result = 0;
            Map<Character,Integer> map = new HashMap<>();
            for(char c: tasks) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            Queue<Integer> q = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
            for(Integer v: map.values()) q.add(v);
            Map<Integer,Integer> idleMap = new HashMap<>();
            while(!q.isEmpty() || !idleMap.isEmpty()) {
                if (idleMap.containsKey(result)) {
                    q.add(idleMap.get(result));
                    idleMap.remove(result);
                }
                if (!q.isEmpty()) {
                    int taskCount = q.poll() - 1;
                    if (taskCount != 0) {
                        idleMap.put(result + n + 1, taskCount);
                    }
                }
                result++;
            }
            return result;
        }
    }
}
