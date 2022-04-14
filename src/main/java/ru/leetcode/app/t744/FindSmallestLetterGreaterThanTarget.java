package ru.leetcode.app.t744;

import org.junit.Assert;

public class FindSmallestLetterGreaterThanTarget {

    /**
     * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
     *
     * Given a characters array letters that is sorted in non-decreasing order and a character target,
     * return the smallest character in the array that is larger than target.
     *
     * Note that the letters wrap around.
     *
     * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
     */
    public static void main(String[] args) {
        Assert.assertEquals('c', nextGreatestLetter(new char[]{'c','f','j'}, 'a'));

        Assert.assertEquals('f', nextGreatestLetter(new char[]{'c','f','j'}, 'c'));

        Assert.assertEquals('f', nextGreatestLetter(new char[]{'c','f','j'}, 'd'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while(start <= end) {
            int middle = end/2 - start/2 + start;
            if (letters[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return letters[start % letters.length];
    }
}
