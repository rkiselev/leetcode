package ru.leetcode.app.t6287;

import static org.junit.Assert.assertEquals;

public class CategorizeBoxAccordingToCriteria {
    /**
     * Given four integers length, width, height, and mass, representing the dimensions and mass of a box,
     * respectively, return a string representing the category of the box.
     *
     * The box is "Bulky" if:
     * Any of the dimensions of the box is greater or equal to 104.
     * Or, the volume of the box is greater or equal to 109.
     * If the mass of the box is greater or equal to 100, it is "Heavy".
     * If the box is both "Bulky" and "Heavy", then its category is "Both".
     * If the box is neither "Bulky" nor "Heavy", then its category is "Neither".
     * If the box is "Bulky" but not "Heavy", then its category is "Bulky".
     * If the box is "Heavy" but not "Bulky", then its category is "Heavy".
     * Note that the volume of the box is the product of its length, width and height.
     *
     */
    public static void main(String[] args) {
        assertEquals("Both", new Solution().categorizeBox(3223, 1271, 2418, 749));
        assertEquals("Heavy", new Solution().categorizeBox(1000, 35,700,300));
        assertEquals("Neither", new Solution().categorizeBox(200, 50,700,50));
        assertEquals("Bulky", new Solution().categorizeBox(10000, 50,700,50));
        assertEquals("Bulky", new Solution().categorizeBox(9999, 9999,9999,50));
        assertEquals("Both", new Solution().categorizeBox(9999, 9999,9999,102));
    }
    static class Solution {
        public String categorizeBox(int length, int width, int height, int mass) {
            var isHeavy = mass >= 100;
            var isBulky = (1L * length * width * height >= 1000000000L ) || length >=   10000 || width >= 10000 || height >= 10000;
            if (isHeavy && isBulky) return "Both";
            if (isHeavy) return "Heavy";
            if (isBulky) return "Bulky";
            return "Neither";
        }
    }
}
