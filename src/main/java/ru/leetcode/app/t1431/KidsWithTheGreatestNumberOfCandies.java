package ru.leetcode.app.t1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KidsWithTheGreatestNumberOfCandies {
    /**
     * There are n kids with candies. You are given an integer array candies, where each candies[i] represents
     * the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that
     * you have.
     *
     * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the
     * extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
     *
     * Note that multiple kids can have the greatest number of candies.
     */
    public static void main(String[] args) {
        assertEquals(List.of(true,false,false,false,false), new Solution().kidsWithCandies(new int[]{4,2,1,1,2}, 1));
        assertEquals(List.of(true,true,true,false,true), new Solution().kidsWithCandies(new int[]{2,3,5,1,3}, 3));
        assertEquals(List.of(true,false,true), new Solution().kidsWithCandies(new int[]{12,1,12}, 10));
    }
    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = Arrays.stream(candies).max().orElse(0);
            List<Boolean> result = new ArrayList<>();
            for (int candy : candies) {
                result.add(candy + extraCandies >= max);
            }
            return result;
        }
    }
}

