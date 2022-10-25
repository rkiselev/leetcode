package ru.leetcode.app.task;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        System.out.println(new Solution().deduplication("Jim went Went To to to school went to"));
        Assert.assertEquals(new Solution().deduplication("Jim went Went To to to school went to"), "Jim went To school");
    }

    static class Solution {

        public String deduplication(String input) {
            List<String> r = new ArrayList<>();
            Set<String> set = new HashSet<>();
            if (input != null) {
                for (String word: input.split(" ")) {
                    if (set.add(word.toLowerCase())) {
                        r.add(word);
                    }
                }
            }

            return String.join(" ", r);
        }
    }
}
/*
    delete duplicate words, keep the first occurrence.

        Sample Input:
        Jim went Went To to to school went to

        Sample Output:
        Jim went To school


 */