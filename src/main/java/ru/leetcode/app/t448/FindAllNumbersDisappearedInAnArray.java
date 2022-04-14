package ru.leetcode.app.t448;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    /**
     * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
     *
     * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of
     * all the integers in the range [1, n] that do not appear in nums.
     */
    public static void main(String[] args) {

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int p = 0;
        while (p < nums.length) {
            int pos = nums[p] - 1;
            if (nums[pos] != nums[p]) {
                int swap = nums[p];
                nums[p] = nums[pos];
                nums[pos] = swap;
            } else {
                p++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
