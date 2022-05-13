package ru.leetcode.app.t47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsII {
    /**
     * https://leetcode.com/problems/permutations-ii/
     * <p>
     * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations
     * in any order.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,1,2]
     * Output:
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * Example 2:
     * <p>
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */

    class Solution {
        private List<List<Integer>> result;

        public List<List<Integer>> permuteUnique(int[] nums) {
            result = new ArrayList<>();
            helper(0, nums);

            return result;

        }

        private void helper(int strt, int[] nums) {
            //if all elements have been traversed
            if (strt == nums.length) {
                List<Integer> ll = Arrays.stream(nums).boxed().collect(Collectors.toList());
                //if ll is already present in the result, then there is no need to add this list item
                if (!result.contains(ll)) {
                    result.add(ll);
                }
                return;
            }
            //swapping the element at the strt index with every other element of the array which is present
            // to the right of the start element this produces all permutations
            for (int i = strt; i < nums.length; i++) {
                swap(strt, i, nums);
                helper(strt + 1, nums);
                //swapping the elements back for further permutations
                swap(strt, i, nums);
            }

        }

        private void swap(int i, int j, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
