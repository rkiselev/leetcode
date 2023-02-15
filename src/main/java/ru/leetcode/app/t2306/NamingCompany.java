package ru.leetcode.app.t2306;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class NamingCompany {
    /**
     * https://leetcode.com/problems/naming-a-company/
     *
     * You are given an array of strings ideas that represents a list of names to be used in the process of naming a
     * company. The process of naming a company is as follows:
     *
     * Choose 2 distinct names from ideas, call them ideaA and ideaB.
     * Swap the first letters of ideaA and ideaB with each other.
     * If both of the new names are not found in the original ideas, then the name ideaA ideaB (the concatenation of
     * ideaA and ideaB, separated by a space) is a valid company name.
     * Otherwise, it is not a valid name.
     * Return the number of distinct valid names for the company.
     *
     * Example 1:
     *
     * Input: ideas = ["coffee","donuts","time","toffee"]
     * Output: 6
     * Explanation: The following selections are valid:
     * - ("coffee", "donuts"): The company name created is "doffee conuts".
     * - ("donuts", "coffee"): The company name created is "conuts doffee".
     * - ("donuts", "time"): The company name created is "tonuts dime".
     * - ("donuts", "toffee"): The company name created is "tonuts doffee".
     * - ("time", "donuts"): The company name created is "dime tonuts".
     * - ("toffee", "donuts"): The company name created is "doffee tonuts".
     * Therefore, there are a total of 6 distinct company names.
     *
     * The following are some examples of invalid selections:
     * - ("coffee", "time"): The name "toffee" formed after swapping already exists in the original array.
     * - ("time", "toffee"): Both names are still the same after swapping and exist in the original array.
     * - ("coffee", "toffee"): Both names formed after swapping already exist in the original array.
     */
    public static void main(String[] args) {
        assertEquals(6, new Solution().distinctNames(new String[]{"coffee","donuts","time","toffee"}));
    }

    static class Solution {
        public long distinctNames(String[] ideas) {
            Map<Character, Set<String>> map = new HashMap<>();
            for (String s: ideas) {
                if (!map.containsKey(s.charAt(0))) {
                    map.put(s.charAt(0), new HashSet<>());
                }
                map.get(s.charAt(0)).add(s.substring(1));
                int pow = (int) Math.pow(10, 5);
            }
            long count = 0;
            for (char c1 : map.keySet()) {
                for( char c2: map.keySet()) {
                    if (c1 == c2) continue;
                    int intersect = 0;
                    for( String word: map.get(c1)) {
                        if (map.get(c2).contains(word)) intersect++;
                    }
                    count += ((long) (map.get(c2).size() - intersect) * (map.get(c1).size() - intersect));
                }
            }

            return count;

        }
    }
}
