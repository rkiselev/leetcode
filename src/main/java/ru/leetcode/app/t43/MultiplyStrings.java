package ru.leetcode.app.t43;

import org.junit.Assert;

public class MultiplyStrings {

    /**
     * https://leetcode.com/problems/multiply-strings/
     *
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
     * also represented as a string.
     *
     * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
     *
     */
    public static void main(String[] args) {
        String multiply = multiply("2", "3");
        Assert.assertEquals("6", multiply);

        multiply = multiply("123", "456");
        Assert.assertEquals("56088", multiply);
    }

    public static String multiply(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();

        // Base Conditions
        if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }


        // Result can be maximum of length M + N.
        // For example 99 * 99 = 9801 (Result is of length 4)
        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = Integer.valueOf(String.valueOf(num1.charAt(i))) * Integer.valueOf(String.valueOf(num2.charAt(j)));
                // Adding previous values in result array into this product.
                product += result[i + j + 1];

                // Adding the new product into the result array
                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }

        // Generating the result String
        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            // Ignoring leading zeros
            if (sb.length() == 0 && r == 0) {
                continue;
            }
            sb.append(r);
        }

        return sb.toString();
    }
}
