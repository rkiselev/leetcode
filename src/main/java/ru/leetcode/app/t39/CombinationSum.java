package ru.leetcode.app.t39;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CombinationSum {
    /**
     * https://leetcode.com/problems/combination-sum/
     * <p>
     * Given an array of distinct integers candidates and a target integer target, return a list of all
     * unique combinations of candidates where the chosen numbers sum to target. You may return the combinations
     * in any order.
     * <p>
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if
     * the frequency of at least one of the chosen numbers is different.
     * <p>
     * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations
     * for the given input.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * Example 2:
     * <p>
     * Input: candidates = [2,3,5], target = 8
     * Output: [[2,2,2,2],[2,3,3],[3,5]]
     * Example 3:
     * <p>
     * Input: candidates = [2], target = 1
     * Output: []
     */
    public static void main(String[] args) {
        var l1 = List.of(2,2,3);
        var l2 = List.of(7);
        var r = List.of(l1,l2);
        assertEquals(r, new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
        l1 = List.of(2,2,2,2);
        l2 = List.of(2,3,3);
        var l3 = List.of(3,5);
        r = List.of(l1,l2,l3);
        assertEquals(r, new Solution().combinationSum(new int[]{2,3, 5}, 8));
        assertEquals(List.of(), new Solution().combinationSum(new int[]{2}, 1));
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            backTrack(new ArrayList<>(), candidates, target, 0, 0);
            return result;
        }

        private void backTrack(List<Integer> items, int[] candidates, int target, int sum, int index) {
            if (sum == target) {
                result.add(new ArrayList<>(items));
                return;
            }
            if (index >= candidates.length || sum > target) return;
            items.add(candidates[index]);
            backTrack(items, candidates, target, sum + candidates[index], index);
            items.remove(items.size() - 1);
            backTrack(items, candidates, target, sum, index + 1);
        }
    }
}
