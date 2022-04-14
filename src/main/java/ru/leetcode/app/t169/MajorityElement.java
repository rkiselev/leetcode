package ru.leetcode.app.t169;

import org.junit.Assert;

public class MajorityElement {

    /**
     * https://leetcode.com/problems/majority-element/
     *
     * <p>
     * Given an array nums of size n, return the majority element.
     * <p>
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the
     * majority element always exists in the array.
     */

    public static void main(String[] args) {
        Assert.assertEquals(3, majorityElement(new int[] {3, 2, 3}));

        Assert.assertEquals(2, majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] nums) {
        int result = 0;
        int voit = 0;
        int i = 0;
        while (i < nums.length) {
            if (result == nums[i]) {
                voit++;
            } else {
                if (voit == 0) {
                    result = nums[i];
                    voit++;
                } else {
                    voit--;
                }
            }
            i++;
        }
        return result;
    }
}
