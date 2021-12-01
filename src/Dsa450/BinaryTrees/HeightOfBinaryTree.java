package src.Dsa450.BinaryTrees;

public class HeightOfBinaryTree {
}

class Solution {
    int height(Node node) {
        return maxRecursiveHeight(node, 1);
    }

    private int maxRecursiveHeight(Node node, int height) {
        if (node == null)
            return -1;

        return Math.max(
            height,
            Math.max(
                maxRecursiveHeight(node.left, height + 1), 
                maxRecursiveHeight(node.right, height + 1)
            )
        );
    }
}
