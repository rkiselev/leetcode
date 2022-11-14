package ru.leetcode.app.hack;

public class SwapCount {
    /**
     * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
     * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
     * You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in
     * ascending order.
     */
    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{4,3,1,2}));
    }

    static int minimumSwaps(int[] arr) {
        int result = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            while(arr[i] != i + 1) {
                swap(arr, i);
                result++;
            }
        }
        return result;
    }

    private static void swap(int[] nums, int index) {
        int swap = nums[index];
        nums[index] = nums[swap - 1];
        nums[swap - 1] = swap;
    }
}
