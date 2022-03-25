package src.Dsa450.BinaryTrees;

import java.util.ArrayDeque;
import java.util.HashMap;

public class MinDistanceBetweenTwoGivenNodesOfABinaryTree {

}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class GfG {
    int findDist(Node root, int a, int b) {
        HashMap<Node, Node> parentRecords = new HashMap<>();

        ArrayDeque<Node> nodeQueue = new ArrayDeque<>();
        ArrayDeque<Integer> levelQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        levelQueue.offer(1);

        Node startNode = null, endNode = null;
        int startNodeLevel = -1, endNodeLevel = -1;

        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            int level = levelQueue.poll();

            if (node.data == a && startNode == null) {
                startNode = node;
                startNodeLevel = level;
            }
            if (node.data == b && endNode == null) {
                endNode = node;
                endNodeLevel = level;
            }

            if (node.left != null) {
                parentRecords.put(node.left, node);
                nodeQueue.offer(node.left);
                levelQueue.offer(level + 1);
            }
            if (node.right != null) {
                parentRecords.put(node.right, node);
                nodeQueue.offer(node.right);
                levelQueue.offer(level + 1);
            }
        }

        int distance = 0;
        while (startNode != endNode) {
            if (startNodeLevel > endNodeLevel) {
                startNode = parentRecords.get(startNode);
                --startNodeLevel;
            } else {
                endNode = parentRecords.get(endNode);
                --endNodeLevel;
            }
            ++distance;
        }

        return distance;
    }
}
