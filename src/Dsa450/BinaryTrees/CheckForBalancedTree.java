package src.Dsa450.BinaryTrees;

public class CheckForBalancedTree {

}

class Tree {
    boolean isBalanced(Node root) {
        return recursiveBalancedHeight(root) != null;
    }

    private Integer recursiveBalancedHeight(Node root) {
        if (root == null)
            return 0;
        Integer left = recursiveBalancedHeight(root.left);
        Integer right = recursiveBalancedHeight(root.right);

        return (left != null && right != null && Math.abs(left - right) <= 1)
                ? Math.max(left, right) + 1
                : null;
    }
}
