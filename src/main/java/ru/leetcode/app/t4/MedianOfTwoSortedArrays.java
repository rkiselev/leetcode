package ru.leetcode.app.t4;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

    /**
     * https://leetcode.com/problems/median-of-two-sorted-arrays/
     *
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     */

    public static void main(String[] args) {
        var r = findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        System.out.println(r);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        List<Integer> v = new ArrayList<>();
        while( i < nums1.length || j < nums2.length ) {
            if (getValue(nums1, i, Integer.MAX_VALUE) <= getValue(nums2, j, Integer.MAX_VALUE)){
                v.add(nums1[i]);
                i++;
            } else {
                v.add(nums2[j]);
                j++;
            }
        }
        double result;
        int index = v.size() / 2;
        if (v.size() % 2 == 0) {
            result = (v.get(index - 1) + v.get(index))/ 2.0d;
        } else {
            result = v.get(index);
        }
        return result;
    }

    private static int getValue(int[] arr, int index, int def) {
        if (index >= arr.length) {
            return def;
        } else {
            return arr[index];
        }
    }
}
