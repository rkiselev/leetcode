package ru.leetcode.app.t347;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    /**
     * https://leetcode.com/problems/top-k-frequent-elements/
     *
     * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer
     * in any order.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     */

    public static void main(String[] args) {
        new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }

    static class Solution {
        public int[] topKFrequentSlow(int[] nums, int k) {
            var map = new TreeMap<Integer, Integer>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            var queue = new PriorityQueue<Map.Entry<Integer, Integer>>((a,b) -> b.getValue().compareTo(a.getValue()));
            map.entrySet().forEach(queue::add);
            var result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = queue.poll().getKey();
            }
            return result;
        }

        public int[] topKFrequent(int[] nums, int k) {
            var map = new TreeMap<Integer, Integer>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            /*
             * переворачиваем мапу как часто встречается к элементу
             */
            var frenToElem = map.entrySet().stream().collect(Collectors.toMap(
                    it -> it.getValue(),
                    it -> {
                        var list = new ArrayList<Integer>();
                        list.add(it.getKey());
                        return list;
                    },
                    (a, b) -> {
                        a.addAll(b);
                        return a;
                    }
                    ));
            int start = nums.length - 1;
            var result = new int[k];
            while (k > 0 && start > 0) {
                var list = frenToElem.getOrDefault(start, new ArrayList<>());
                if (!list.isEmpty()) {
                    for (Integer elem: list) {
                        result[k - 1] = elem;
                        k--;
                        if (k < 0) break;
                    }
                }
                start--;
            }

            return result;
        }
    }
}
