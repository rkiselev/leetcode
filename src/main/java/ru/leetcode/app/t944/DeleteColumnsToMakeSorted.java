package ru.leetcode.app.t944;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class DeleteColumnsToMakeSorted {
    /**
     * https://leetcode.com/problems/delete-columns-to-make-sorted/
     *You are given an array of n strings strs, all of the same length.
     *
     * The strings can be arranged such that there is one on each line, making a grid. For example,
     * strs = ["abc", "bce", "cae"] can be arranged as:
     *
     * abc
     * bce
     * cae
     * You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed),
     * columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted while column 1 ('b', 'c', 'a') is not, so you would
     * delete column 1.
     *
     * Return the number of columns that you will delete.
     */
    public static void main(String[] args) {
        Assert.assertEquals(1, new Solution().minDeletionSize(new String[]{"abc", "bce", "cae"}));
        Assert.assertEquals(0, new Solution().minDeletionSize(new String[]{"a", "b", "c"}));
        Assert.assertEquals(1, new Solution().minDeletionSize(new String[]{"cba","daf","ghi"}));
        Assert.assertEquals(0, new Solution().minDeletionSize(new String[]{"a"}));
        Assert.assertEquals(3, new Solution().minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }

    static class Solution {
        public int minDeletionSize(String[] strs) {
            int result = 0;
            if(strs.length == 1) return result;

            int rowIndex = 0;
            int maxIndex = strs.length;
            int wordSize = strs[0].length();
            int letterIndex = 0;
            while(letterIndex < wordSize) {
                char first = strs[rowIndex].charAt(letterIndex);
                char second = strs[rowIndex + 1].charAt(letterIndex);
                if (first > second) {
                    result++;
                    rowIndex = 0;
                    letterIndex++;
                } else {
                    rowIndex++;
                    if (rowIndex + 1 == maxIndex) {
                        rowIndex = 0;
                        letterIndex++;
                    }
                }

            }
            return result;
        }
    }
}
