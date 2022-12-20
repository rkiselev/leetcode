package ru.leetcode.app.t841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KeysAndRooms {
    /**
     * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to
     * visit all the rooms. However, you cannot enter a locked room without having its key.
     *
     * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which
     * room it unlocks, and you can take all of them with you to unlock the other rooms.
     *
     * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true
     * if you can visit all the rooms, or false otherwise.
     *
     * Example 1:
     *
     * Input: rooms = [[1],[2],[3],[]]
     * Output: true
     * Explanation:
     * We visit room 0 and pick up key 1.
     * We then visit room 1 and pick up key 2.
     * We then visit room 2 and pick up key 3.
     * We then visit room 3.
     * Since we were able to visit every room, we return true.
     * Example 2:
     *
     * Input: rooms = [[1,3],[3,0,1],[2],[0]]
     * Output: false
     * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
     */
    public static void main(String[] args) {
        assertTrue(new Solution().canVisitAllRooms(List.of(List.of(1),List.of(2),List.of(3),List.of())));
        assertFalse(new Solution().canVisitAllRooms(List.of(List.of(1,3),List.of(1,3,0),List.of(2),List.of(0))));
    }

    static class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n];
            visited[0] = true;
            for (int key : rooms.get(0)) q.add(key);
            while(!q.isEmpty()) {
                int key = q.poll();
                if (!visited[key]) {
                    for (int it : rooms.get(key)) {
                        q.add(it);
                    }
                    visited[key] = true;
                }
            }
            for (boolean it: visited) {
                if (!it) return false;
            }
            return true;
        }
    }
}
