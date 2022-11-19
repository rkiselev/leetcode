package ru.leetcode.app.task;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {
    static int a;
    /*The expectation is that you will write a method that will take two strings as inputs and print out the
        unique characters between the two strings

For Example, let's say the two strings are:

	S1 = LOS ANGELESO

	S2 = LAS VEGASV

	The output = O, V, N


You will need to do this with O(n) time complexity & O(n) Space complexity.
*/
    public static void main(String[] args) {

        uniqueCharacters("LOS ANGELESO", "LAS VEGASV");
    }

    public static void uniqueCharacters(String s1, String s2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        charToSet(set1, s1);
        charToSet(set2, s2);

        System.out.println(a);
        for (char c: set1) {
            if (set2.contains(c)) {
                set2.remove(c);
            } else {
                set2.add(c);
            }
        }
        for(char c: set2) {
            System.out.println(c);
        }
    }

    static void charToSet(Set<Character> set, String s) {
        for(char c: s.toCharArray()) {
            set.add(c);
        }
    }
}
