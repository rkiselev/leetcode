package ru.leetcode.app.t40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CombinationSumII {
    /**
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
     * in candidates where the candidate numbers sum to target.
     *
     * Each number in candidates may only be used once in the combination.
     *
     * Note: The solution set must not contain duplicate combinations.
     *
     *
     *
     * Example 1:
     *
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,5,2,1,2], target = 5
     * Output:
     * [
     * [1,2,2],
     * [5]
     * ]
     */

    public static void main(String[] args) {
        var l1 = List.of(1,2,2);
        var l2 = List.of(5);
        var r = List.of(l1,l2);
        assertEquals(r, new Solution().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
    static class Solution {
        private List<List<Integer>>result = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backTrack(new ArrayList<>(), candidates, target, 0, 0);
            return result;
        }

        private void backTrack(List<Integer> items, int[] candidates, int target, int sum, int index) {
            if (sum == target) {
                result.add(new ArrayList<>(items));
                return;
            }
            if (sum > target) return;
            int prev = -1;
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] == prev) continue;
                items.add(candidates[i]);
                backTrack(items, candidates, target, sum + candidates[i], i + 1);
                items.remove(items.size() - 1);
                prev = candidates[i];
            }
        }
    }
}
