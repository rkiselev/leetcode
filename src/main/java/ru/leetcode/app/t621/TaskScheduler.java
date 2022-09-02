package ru.leetcode.app.t621;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TaskScheduler {
    public static void main(String[] args) {
        assertEquals(16, new Solution().leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2));
        assertEquals(8, new Solution().leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }

    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            Map<Character,Integer> map = new HashMap<>();
            for (char c: tasks) {
                Integer count = map.getOrDefault(c, 0);
                map.put(c, ++count);
            }
            int result = 0;
            PriorityQueue<Integer> p = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
            Queue<int[]> q = new LinkedList<>();
            for (Integer val: map.values()) {
                p.add(val);
            }
            while(!p.isEmpty() || !q.isEmpty()) {
                if (!q.isEmpty()) {
                    int[]candidate = q.peek();
                    if (candidate[1] == result) {
                        q.poll();
                        p.add(candidate[0]);
                    }
                }

                if (!p.isEmpty()) {
                    Integer current = p.poll();
                    current--;
                    result++;
                    if (current > 0) {
                        q.add(new int[]{current, result + n});
                    }
                } else {
                    result++;
                }

            }

            return result;
        }
    }
}
