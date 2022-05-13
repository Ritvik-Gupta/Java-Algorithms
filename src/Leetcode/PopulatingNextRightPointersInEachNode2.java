package src.Leetcode;

public class PopulatingNextRightPointersInEachNode2 {
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {
        final Node BUFFER_LINK_NODE = new Node(-101);

        Node levelHead = root;
        while (levelHead != null) {
            Node connectionPointer = BUFFER_LINK_NODE;
            for (Node currNode = levelHead; currNode != null; currNode = currNode.next) {
                if (currNode.left != null) {
                    connectionPointer.next = currNode.left;
                    connectionPointer = currNode.left;
                }
                if (currNode.right != null) {
                    connectionPointer.next = currNode.right;
                    connectionPointer = currNode.right;
                }
            }

            levelHead = BUFFER_LINK_NODE.next;
            BUFFER_LINK_NODE.next = null;
        }
        return root;
    }
}
