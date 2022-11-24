package ru.leetcode.app.t133;

import ru.leetcode.app.Node;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    /**
     * https://leetcode.com/problems/clone-graph/
     *
     * Given a reference of a node in a connected undirected graph.
     *
     * Return a deep copy (clone) of the graph.
     *
     * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
     *
     * class Node {
     *     public int val;
     *     public List<Node> neighbors;
     * }
     *
     *
     * Test case format:
     *
     * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node
     * with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an
     * adjacency list.
     *
     * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the
     * set of neighbors of a node in the graph.
     *
     * The given node will always be the first node with val = 1. You must return the copy of the given node as a
     * reference to the cloned graph.
     */

    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Map<Node, Node> oldToNew = new HashMap<Node, Node>();
            return clone(node, oldToNew);
        }

        private Node clone(Node node, Map<Node,Node> oldToNew) {
            var copy = oldToNew.get(node);
            if (copy != null) return copy;
            copy = new Node(node.val);
            oldToNew.put(node, copy);
            for (Node neighbor: node.neighbors) {
                copy.neighbors.add(clone(neighbor, oldToNew));
            }
            return copy;
        }
    }
}
