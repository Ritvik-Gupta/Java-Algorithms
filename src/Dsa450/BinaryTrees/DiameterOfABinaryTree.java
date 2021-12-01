package src.Dsa450.BinaryTrees;

public class DiameterOfABinaryTree {
}

class Solution {
    int diameter(Node root) {
        return maxRecursiveDepth(root).diameter;
    }

    private static class MaxChildResult {
        int depth, diameter;

        public MaxChildResult(int depth, int diameter) {
            this.depth = depth;
            this.diameter = diameter;
        }
    }

    private static final MaxChildResult NULL_NODE_RESULT = new MaxChildResult(0, 0);

    private MaxChildResult maxRecursiveDepth(Node node) {
        if (node == null)
            return NULL_NODE_RESULT;

        MaxChildResult left = maxRecursiveDepth(node.left), right = maxRecursiveDepth(node.right); 
        return new MaxChildResult(
            Math.max(left.depth, right.depth) + 1,
            Math.max(left.depth + right.depth + 1, Math.max(left.diameter, right.diameter))
        );
    }
}
