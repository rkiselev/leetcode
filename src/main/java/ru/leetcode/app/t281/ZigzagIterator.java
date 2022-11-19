package ru.leetcode.app.t281;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
    /**
     * Given two 1d vectors, implement an iterator to return their elements alternately.For example, given two 1d vectors:
     * v1 = [1, 2]
     * v2 = [3, 4, 5, 6]
     * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be:
     * [1, 3, 2, 4, 5, 6]
     */
    public static void main(String[] args) {
        List<Integer>l1 = List.of(1,3,5,7,9);
        List<Integer>l2 = List.of(2,4,6,8);
        var i = new ZigzagIterator(l1, l2);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    Queue<Iterator<Integer>> iterators;
    public ZigzagIterator(List<Integer> first, List<Integer> second) {
        iterators = new LinkedList<>();
        iterators.add(first.iterator());
        iterators.add(second.iterator());
    }
    public boolean hasNext() {
        return iterators.size() > 0;
    }

    public int next() {
        var it = iterators.poll();
        var result = it.next();
        if(it.hasNext()) iterators.add(it);
        return result;
    }
}
