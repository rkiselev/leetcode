package ru.leetcode.app.t7;

import org.junit.Assert;

public class ReverseInteger {

    /*
     * https://leetcode.com/problems/reverse-integer/
     *
     * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go
     * outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     *
     */
    public static void main(String[] args) {
        Assert.assertEquals(321, reverse(123));
        Assert.assertEquals(-321, reverse(-123));
        Assert.assertEquals(21, reverse(120));
        Assert.assertEquals(0, reverse(1534236469));
    }

    private static int reverse(int x) {
        boolean revers = x < 0;
        int result = 0;
        x = Math.abs(x);
        while (x > 0) {
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (revers) result *= -1;

        return result;
    }
}
