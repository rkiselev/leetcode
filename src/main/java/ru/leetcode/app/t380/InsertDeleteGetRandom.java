package ru.leetcode.app.t380;

import java.util.*;

public class InsertDeleteGetRandom {
    /**
     * https://leetcode.com/problems/insert-delete-getrandom-o1/
     *
     * Implement the RandomizedSet class:
     *
     * RandomizedSet() Initializes the RandomizedSet object.
     * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present,
     * false otherwise.
     * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false
     * otherwise.
     * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one
     * element exists when this method is called). Each element must have the same probability of being returned.
     * You must implement the functions of the class such that each function works in average O(1) time complexity.
     */
    public static void main(String[] args) {
        var item = new RandomizedSet();
        item.insert(5);
        item.insert(6);
        item.insert(7);
        item.insert(8);
        item.insert(9);
        item.remove(7);
    }

    static class RandomizedSet {
        Random rand;
        List<Integer> list;
        Map<Integer, Integer> valToIndex;

        public RandomizedSet() {
            rand = new Random();
            list = new ArrayList<>();
            valToIndex = new HashMap<>();
        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) return false;
            int index = list.size();
            valToIndex.put(val, index);
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) return false;
            int index = valToIndex.get(val);
            int backup = list.get(list.size() - 1);
            valToIndex.put(backup, index);
            list.set(index, backup);
            list.remove(list.size() - 1);
            valToIndex.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
