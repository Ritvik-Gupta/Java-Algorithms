package src.Dsa450.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
}

class Solution {
    static ArrayList<Integer> levelOrder(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();
            if (currNode != null) {
                result.add(currNode.data);
                nodeQueue.offer(currNode.left);
                nodeQueue.offer(currNode.right);
            }
        }

        return result;
    }
}
