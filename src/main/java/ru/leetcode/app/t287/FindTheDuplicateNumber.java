package ru.leetcode.app.t287;

import org.junit.Assert;

public class FindTheDuplicateNumber {

    /**
     * https://leetcode.com/problems/find-the-duplicate-number/
     * <p>
     * <p>
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     * There is only one repeated number in nums, return this repeated number.
     * You must solve the problem without modifying the array nums and uses only constant extra space.
     */
    public static void main(String[] args) {
        Assert.assertEquals(2, findDuplicate(new int[] {1, 3, 4, 2, 2}));

        Assert.assertEquals(3, findDuplicate(new int[] {3, 1, 3, 4, 2}));
    }

    public static int findDuplicate(int[] nums) {
        boolean interf = false;
        int slow = nums[0];
        int fast = nums[0];
        while (!interf) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            interf = fast == slow;
        }

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }
}
