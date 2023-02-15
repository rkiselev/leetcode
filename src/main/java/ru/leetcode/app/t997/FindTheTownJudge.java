package ru.leetcode.app.t997;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class FindTheTownJudge {
    /**
     * https://leetcode.com/problems/find-the-town-judge/description/
     * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the
     * town judge.
     *
     * If the town judge exists, then:
     *
     * The town judge trusts nobody.
     * Everybody (except for the town judge) trusts the town judge.
     * There is exactly one person that satisfies properties 1 and 2.
     * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person
     * labeled bi.
     *
     * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
     *
     * Example 1:
     *
     * Input: n = 2, trust = [[1,2]]
     * Output: 2
     * Example 2:
     *
     * Input: n = 3, trust = [[1,3],[2,3]]
     * Output: 3
     * Example 3:
     *
     * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
     * Output: -1
     */
    public static void main(String[] args) {
        assertEquals(1, new Solution().findJudge(1, new int[0][2]));
        assertEquals(2, new Solution().findJudge(2, new int[][]{{1,2}}));
        assertEquals(3, new Solution().findJudge(3, new int[][]{{1,3}, {2,3}}));
        assertEquals(-1, new Solution().findJudge(3, new int[][]{{1,3}, {2,3}, {3,1}}));
        assertEquals(-1, new Solution().findJudge(3, new int[][]{{1,2}, {2,3}}));
        Queue<int[]> queue = new ArrayDeque<>();
        queue.poll();
    }

    static class Solution {
        public int findJudge(int n, int[][] trust) {
            if (n == 1 && trust.length == 0) return 1;
            Set<Integer> trustSet = new HashSet<>();
            Map<Integer, List<Integer>> trusted = new HashMap<>();
            for (int[] ints : trust) {
                trustSet.add(ints[0]);
                if (trusted.containsKey(ints[1])) {
                    trusted.get(ints[1]).add(ints[0]);
                } else {
                    var list = new ArrayList<Integer>();
                    list.add(ints[0]);
                    trusted.put(ints[1], list);
                }

            }
            for (int i = 1; i <= n; i++) {
                if (!trustSet.contains(i)) {
                    if (trusted.containsKey(i) && trusted.get(i).size() == n - 1) {
                        return i;
                    } else {
                        return -1;
                    }
                }
            }
            return -1;
        }
    }
}
