package src.Dsa450.BinaryTrees;

import java.util.ArrayDeque;

public class LeafAtSameLevel {

}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    class LevelNode {
        Node node;
        int level;

        LevelNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }

        LevelNode left() {
            return new LevelNode(this.node.left, this.level + 1);
        }

        LevelNode right() {
            return new LevelNode(this.node.right, this.level + 1);
        }
    }

    boolean check(Node root) {
        Integer leafLevel = null;

        ArrayDeque<LevelNode> nodeStack = new ArrayDeque<>();
        nodeStack.addLast(new LevelNode(root, 1));

        while (!nodeStack.isEmpty()) {
            LevelNode levelNode = nodeStack.removeLast();

            if (levelNode.node.left == null && levelNode.node.right == null) {
                if (leafLevel == null)
                    leafLevel = levelNode.level;
                else if (leafLevel != levelNode.level)
                    return false;
            }

            if (levelNode.node.left != null)
                nodeStack.addLast(levelNode.left());

            if (levelNode.node.right != null)
                nodeStack.addLast(levelNode.right());
        }

        return true;
    }
}
