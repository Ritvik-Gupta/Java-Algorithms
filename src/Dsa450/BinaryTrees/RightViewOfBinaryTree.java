package src.Dsa450.BinaryTrees;

import java.util.ArrayList;

public class RightViewOfBinaryTree {
}

class Solution {
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        recursiveLastLevelNode(root, 0, result);
        return result;
    }

    private void recursiveLastLevelNode(Node node, int height, ArrayList<Integer> result) {
        if (node == null)
            return;

        if (result.size() == height)
            result.add(node.data);

        recursiveLastLevelNode(node.right, height + 1, result);
        recursiveLastLevelNode(node.left, height + 1, result);
    }
}
