package ru.leetcode.app.t207;

import org.junit.Assert;

import java.util.*;

public class CourseSchedule {
    /**
     * https://leetcode.com/problems/course-schedule/
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
     * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course
     * bi first if you want to take course ai.
     *
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     *
     *
     *
     * Example 1:
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     *
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
     * So it is impossible.
     */
    public static void main(String[] args) {
        Assert.assertTrue(new Solution().canFinish(2, new int[][]{{1,0}}));
        Assert.assertFalse(new Solution().canFinish(2, new int[][]{{1,0}, {0,1}}));
    }

    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> courses = new HashMap<>();
            for(int i = 0; i < prerequisites.length; i++) {
                List<Integer> list = courses.get(prerequisites[i][0]);
                if (list == null) {
                    list = new ArrayList<>();
                    courses.put(prerequisites[i][0], list);
                }
                list.add(prerequisites[i][1]);
            }
            for(int i = 0; i < numCourses; i++) {
                if (!isPossibleFinish(courses, i, new HashSet<>())) return false;
            }
            return true;
        }

        private boolean isPossibleFinish(
                Map<Integer,List<Integer>> courses, int course, Set<Integer> visited) {
            if (visited.contains(course)) return false;
            if (!courses.containsKey(course)) return true;
            if (courses.get(course).isEmpty()) return true;
            visited.add(course);
            for(int c: courses.get(course)) {
                if (!isPossibleFinish(courses, c, visited)) return false;
            }
            visited.remove(course);
            courses.put(course, new ArrayList<>());
            return true;
        }
    }
}
