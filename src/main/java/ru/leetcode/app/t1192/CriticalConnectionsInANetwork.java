package ru.leetcode.app.t1192;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CriticalConnectionsInANetwork {

    /**
     * https://leetcode.com/problems/critical-connections-in-a-network/
     *
     * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a
     * network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can
     * reach other servers directly or indirectly through the network.
     *
     * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
     *
     * Return all critical connections in the network in any order.
     */
    public static void main(String[] args) {
        var l1 = List.of(0,1);
        var l2 = List.of(1,2);
        var l3 = List.of(2,0);
        var l4 = List.of(1,3);
        var l = List.of(l1,l2,l3,l4);
        assertEquals(List.of(List.of(1,3)), new Solution().criticalConnections(4, l));

    }

    static class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] dis = new int[n];
            int[] min = new int[n];
            for (List<Integer> item : connections) {
                var list = map.computeIfAbsent(item.get(0), k -> new ArrayList<>());
                list.add(item.get(1));
                list = map.computeIfAbsent(item.get(1), k -> new ArrayList<>());
                list.add(item.get(0));
            }
            var visited = new HashSet<Integer>();
            dfs(0, -1, visited, dis, min, 0, map);
            return result;
        }

        private void dfs(int current, int prev, Set<Integer> visited, int[] dis, int[] min, int time,
                         Map<Integer, List<Integer>> map) {
            visited.add(current);
            time++;
            dis[current] = time;
            min[current] = time;
            for (int next : map.get(current)) {
                if (!visited.contains(next)) {
                    dfs(next, current, visited, dis, min, time, map);
                    min[current] = Math.min(min[current], min[next]);

                } else if (next != prev) {
                    min[current] = Math.min(min[current], dis[next]);
                }
                if (min[next] > dis[current]) {
                    result.add(List.of(current, next));
                }
            }
        }

    }
}
