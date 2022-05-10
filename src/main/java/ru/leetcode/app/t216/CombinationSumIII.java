package ru.leetcode.app.t216;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        new Solution().combinationSum3(3,7);
    }
    static class Solution {

        /**
         *Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
         *
         * Only numbers 1 through 9 are used.
         * Each number is used at most once.
         * Return a list of all possible valid combinations. The list must not contain the same combination twice,
         * and the combinations may be returned in any order.
         *
         *
         *
         * Example 1:
         *
         * Input: k = 3, n = 7
         * Output: [[1,2,4]]
         * Explanation:
         * 1 + 2 + 4 = 7
         * There are no other valid combinations.
         * Example 2:
         *
         * Input: k = 3, n = 9
         * Output: [[1,2,6],[1,3,5],[2,3,4]]
         * Explanation:
         * 1 + 2 + 6 = 9
         * 1 + 3 + 5 = 9
         * 2 + 3 + 4 = 9
         * There are no other valid combinations.
         * Example 3:
         *
         * Input: k = 4, n = 1
         * Output: []
         * Explanation: There are no valid combinations.
         * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and
         * since 10 > 1, there are no valid combination.
         */

        private List<List<Integer>> result;
        public List<List<Integer>> combinationSum3(int k, int n) {
            result = new ArrayList<>();
            dfs(new ArrayList<>(), 1, 0, k, n);
            return result;
        }

        private void dfs(List<Integer> build, int num, int curSum, int count, int target) {
            if (build.size() >= count) {

                if (curSum == target) result.add(new ArrayList<>(build));
                return;
            }
            for (int i = num; i <= 9; i++) {
                curSum += i;
                if (curSum > target) break;
                build.add(i);
                dfs(build, i + 1, curSum, count, target);
                int removed = build.remove(build.size() - 1);
                curSum-=removed;
            }
        }
    }
}
