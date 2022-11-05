package ru.leetcode.app.t204;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountPrimes {
    public static void main(String[] args) {
        Assert.assertEquals(0, new Solution().countPrimes(1));
        Assert.assertEquals(2, new Solution().countPrimes(5));
        Assert.assertEquals(0, new FastSolution().countPrimes(1));
        Assert.assertEquals(2, new FastSolution().countPrimes(5));
    }

    static class Solution {
        public int countPrimes(int n) {
            List<Integer> range = IntStream.range(2, n).boxed().collect(Collectors.toList());
            int index = 0;
            while (index < range.size()) {
                List<Integer> toRemove = new ArrayList<>();
                int p = range.get(index);
                int val = p * p;
                while(val <= range.get(range.size() - 1)) {
                    toRemove.add(val);
                    val += p;
                }
                range.removeAll(toRemove);
                index++;
            }
            return range.size();
        }
    }

    static class FastSolution {
        public int countPrimes(int n) {
            if (n <= 2) return 0;
            boolean[] arr = new boolean[n];
            Arrays.fill(arr, true);
            arr[0] = false;
            arr[1] = false;
            int index = 2;
            for (int i = 2; i * i < arr.length; i++) {
                for (int j = 2 * i;  j < arr.length; j+=i) {
                    arr[j] = false;
                }
            }
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]) count++;
            }
            return count;
        }
    }
}
