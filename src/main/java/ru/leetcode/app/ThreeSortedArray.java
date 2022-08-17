package ru.leetcode.app;

import static org.junit.Assert.assertEquals;

public class ThreeSortedArray {
    public static void main(String[] args) {
        var solution = new ThreeSortedArray();
        int result = solution.solution(new int[]{1,2,4,5}, new int[]{3,3,4}, new int[]{2,3,4,5,6});
        assertEquals(4, result);

        result = solution.solution(new int[]{1,2,3,4, 5}, new int[]{5,6,7}, new int[]{1,2,3,5});
        assertEquals(5, result);
    }

    public int solution(int[] arr1, int[] arr2, int[] arr3) {
        int result = -1;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (result < 0 && index1 < arr1.length && index2 < arr2.length && index3 < arr3.length ) {
            if (arr1[index1] == arr2[index2] && arr1[index1] == arr3[index3]) {
                result = arr1[index1];
                continue;
            }
            if (arr1[index1] < arr2[index2]) {
                index1++;
            } else if (arr2[index2] < arr3[index3]) {
                index2++;
            } else {
                index3++;
            }
        }
        return result;
    }
}
