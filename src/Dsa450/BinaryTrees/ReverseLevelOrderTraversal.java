package src.Dsa450.BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
}

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();
            if (currNode != null) {
                result.add(currNode.data);
                nodeQueue.offer(currNode.right);
                nodeQueue.offer(currNode.left);
            }
        }

        Collections.reverse(result);
        return result;
    }
}
