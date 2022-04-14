package ru.leetcode.app.t70;

import org.junit.Assert;

public class ClimbingStairs {

    /**
     * https://leetcode.com/problems/climbing-stairs/
     *
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     */
    public static void main(String[] args) {
        Assert.assertEquals(2, climbStairs(2));
        Assert.assertEquals(3, climbStairs(3));
        Assert.assertEquals(89, climbStairs(10));
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        int n1 = 2;
        int n2 = 3;

        for (int i = 3; i <n; i++) {
            int swap = n1;
            n1 = n2;
            n2+= swap;
        }

        return n2;
    }
}
