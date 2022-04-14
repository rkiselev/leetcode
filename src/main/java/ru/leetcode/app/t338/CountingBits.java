package ru.leetcode.app.t338;

import org.junit.Assert;

public class CountingBits {

    /**
     * https://leetcode.com/problems/counting-bits/
     * <p>
     * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the
     * number of 1's in the binary representation of i.
     */
    public static void main(String[] args) {
        int[] ints = countBits(2);
        Assert.assertEquals(0, ints[0]);
        Assert.assertEquals(1, ints[1]);
        Assert.assertEquals(1, ints[2]);

        ints = countBits(5);
        Assert.assertEquals(0, ints[0]);
        Assert.assertEquals(1, ints[1]);
        Assert.assertEquals(1, ints[2]);
        Assert.assertEquals(2, ints[3]);
        Assert.assertEquals(1, ints[4]);
        Assert.assertEquals(2, ints[5]);
    }

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];

        int p = 1; //p tracks the index for number x
        int pow = 1;
        for (int i = 1; i <= n; i++) {
            if (i == pow) {
                result[i] = 1;
                pow <<= 1;
                p = 1;
            } else {
                result[i] = result[p] + 1;
                p++;
            }

        }
        return result;
    }
}
