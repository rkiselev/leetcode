package ru.leetcode.app.t45;

import org.junit.Assert;

public class JumpGameII {

    /**
     * https://leetcode.com/problems/jump-game-ii/
     * <p>
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Your goal is to reach the last index in the minimum number of jumps.
     * <p>
     * You can assume that you can always reach the last index.
     */
    public static void main(String[] args) {
        Assert.assertEquals(2, jump(new int[]{2,3,1,1,4}));

        Assert.assertEquals(2, jump(new int[]{2,3,0,1,4}));
    }

    public static int jump(int[] nums) {
        int i, j;
        int n = nums.length;
        int[] pre = new int[n];
        for (i = 0; i < n; i++) {
            // Initialize all the index position with some max value to denote it is unreachable
            pre[i] = Integer.MAX_VALUE;
        }

        // Make the first position value as 0 as it is the default place where we start
        pre[0] = 0;
        // Main condition check goes here.
        for (i = 0; i < n; i++) {

            /*
             Each value in the nums array specifies the jump that is possible to take from the current position.
             So if the value in the ith index is nums[i], then it is understandable that from (ith) position to
             (i+nums[i])th position (i, i+1, i+2, ...., i+nums[i]), it can be reached in a single jump. However as
             already mentioned, since a particular position can be reached from various other position, we need to
             store the minimum possible jump value to reach the position.
             pre[j] = Math.min(pre[j], pre[i]+1).
            */
            for (j = i; j <= i + nums[i] && j < n; j++) {
                pre[j] = Math.min(pre[j], pre[i] + 1);
            }
        }
        return pre[n - 1];
    }
}
