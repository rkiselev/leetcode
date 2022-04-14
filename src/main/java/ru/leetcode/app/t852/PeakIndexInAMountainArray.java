package ru.leetcode.app.t852;

import org.junit.Assert;

public class PeakIndexInAMountainArray {

    /**
     * https://leetcode.com/problems/peak-index-in-a-mountain-array/
     *
     * Let's call an array arr a mountain if the following properties hold:
     *
     * arr.length >= 3
     * There exists some i with 0 < i < arr.length - 1 such that:
     * arr[0] < arr[1] < ... arr[i-1] < arr[i]
     * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     * Given an integer array arr that is guaranteed to be a mountain, return any i such that
     * arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
     */
    public static void main(String[] args) {
        Assert.assertEquals(1, peakIndexInMountainArray(new int[]{0,1,0}));

        Assert.assertEquals(1, peakIndexInMountainArray(new int[]{0,2,1,0}));

        Assert.assertEquals(1, peakIndexInMountainArray(new int[]{0,10,5,2}));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int result = -1;
        int start = 0;
        int end = arr.length - 1;
        while(result < 0) {
            int middle = end/2 - start/2 + start;
            if (arr[middle - 1] < arr[middle] && arr[middle] > arr[middle + 1]) {
                result = middle;
            } else if (arr[middle - 1] < arr[middle + 1]) {
                start = middle;
            } else {
                end = middle;
            }
        }

        return result;
    }
}
