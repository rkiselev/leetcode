package ru.leetcode.app.t146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = this.left;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        map.put(key, new Node(key, value));
        insert(map.get(key));

        if (map.size() > capacity) {
            // remove from the list and delte the LRU from the hashmap
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    private class Node {

        private int key;
        private int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

