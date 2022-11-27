package ru.leetcode.app.t210;

import org.junit.Assert;

import java.util.*;

public class CourseScheduleII {
    /**
     * https://leetcode.com/problems/course-schedule-ii/
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an
     * array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want
     * to take course ai.
     *
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return
     * any of them. If it is impossible to finish all courses, return an empty array.
     *
     *
     *
     * Example 1:
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: [0,1]
     * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the
     * correct course order is [0,1].
     * Example 2:
     *
     * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * Output: [0,2,1,3]
     * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1
     * and 2. Both courses 1 and 2 should be taken after you finished course 0.
     * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
     * Example 3:
     *
     * Input: numCourses = 1, prerequisites = []
     * Output: [0]
     */
    public static void main(String[] args) {
        Assert.assertArrayEquals(new int[]{0,1,2,3}, new Solution().findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
        Assert.assertArrayEquals(new int[]{0,1}, new Solution().findOrder(2, new int[][]{{1,0}}));
        Assert.assertArrayEquals(new int[]{}, new Solution().findOrder(2, new int[][]{{1,0}, {0,1}}));
    }

    static class Solution {
        List<Integer> result = new ArrayList<>();
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            Map<Integer,List<Integer>> courses = new HashMap<>();
            for(int i = 0; i < prerequisites.length; i++) {
                List<Integer> l = courses.get(prerequisites[i][0]);
                if (l == null) {
                    l = new ArrayList<>();
                    courses.put(prerequisites[i][0], l);
                }
                l.add(prerequisites[i][1]);
            }
            Set<Integer> visited = new HashSet<>();
            for(int i = 0; i < numCourses; i++) {
                if (!isPossibleFinish(courses, i, visited, new HashSet<>())) return new int[]{};
            }
            int [] r = new int[result.size()];
            for(int i = 0; i < result.size(); i++) r[i] = result.get(i);
            return r;
        }

        private boolean isPossibleFinish(Map<Integer,List<Integer>> courses, int course,
                                         Set<Integer> visited, Set<Integer> current) {
            if (current.contains(course)) return false;
            if (visited.contains(course)) return true;
            current.add(course);
            for(int c: courses.getOrDefault(course, new ArrayList<>())) {
                if(!isPossibleFinish(courses, c, visited, current)) return false;
            }
            visited.add(course);
            current.remove(course);
            result.add(course);
            return true;
        }
    }
}
