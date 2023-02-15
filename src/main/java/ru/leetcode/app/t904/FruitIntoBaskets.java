package ru.leetcode.app.t904;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FruitIntoBaskets {
    /**
     * https://leetcode.com/problems/fruit-into-baskets/
     * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are
     * represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
     *
     * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
     *
     * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the
     * amount of fruit each basket can hold.
     * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start
     * tree) while moving to the right. The picked fruits must fit in one of your baskets.
     * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
     * Given the integer array fruits, return the maximum number of fruits you can pick.
     *
     * Example 1:
     *
     * Input: fruits = [1,2,1]
     * Output: 3
     * Explanation: We can pick from all 3 trees.
     * Example 2:
     *
     * Input: fruits = [0,1,2,2]
     * Output: 3
     * Explanation: We can pick from trees [1,2,2].
     * If we had started at the first tree, we would only pick from trees [0,1].
     * Example 3:
     *
     * Input: fruits = [1,2,3,2,2]
     * Output: 4
     * Explanation: We can pick from trees [2,3,2,2].
     * If we had started at the first tree, we would only pick from trees [1,2].
     */

    public static void main(String[] args) {
        assertEquals(5, new Solution().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

    static class Solution {
        public int totalFruit(int[] fruits) {
            int result = 0;
            Map<Integer,Integer> types = new HashMap<>();
            int start = 0;
            int end = 0;
            int current = 0;
            while(end < fruits.length) {
                types.put(fruits[end], types.getOrDefault(fruits[end++], 0) + 1);
                while(types.size() > 2 && end != start) {
                    var count = types.get(fruits[start]) - 1;
                    if (count == 0 ) {
                        types.remove(fruits[start]);
                    } else {
                        types.put(fruits[start], count);
                    }
                    start++;
                    current--;
                }
                current++;
                result = Math.max(current, result);
            }
            return result;
        }
    }
}
