package src.Dsa450.BinaryTrees;

import java.util.ArrayList;

public class LeftViewOfBinaryTree {
}

class Tree {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        recursiveFistLevelNode(root, 0, result);
        return result;
    }

    private void recursiveFistLevelNode(Node node, int height, ArrayList<Integer> result) {
        if (node == null)
            return;

        if (result.size() == height)
            result.add(node.data);

        recursiveFistLevelNode(node.left, height + 1, result);
        recursiveFistLevelNode(node.right, height + 1, result);
    }
}
