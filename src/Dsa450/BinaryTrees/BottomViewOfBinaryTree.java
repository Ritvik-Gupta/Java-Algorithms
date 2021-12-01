package src.Dsa450.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> result = new TreeMap<>();
        Queue<Map.Entry<Node, Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(Map.entry(root, 0));

        while (!nodeQueue.isEmpty()) {
            Map.Entry<Node, Integer> entry = nodeQueue.poll();
            Node node = entry.getKey();
            int length = entry.getValue();
            result.put(length, node.data);

            if (node.left != null)
                nodeQueue.offer(Map.entry(node.left, length - 1));
            if (node.right != null)
                nodeQueue.offer(Map.entry(node.right, length + 1));
        }

        return new ArrayList<>(result.values());
    }
}
