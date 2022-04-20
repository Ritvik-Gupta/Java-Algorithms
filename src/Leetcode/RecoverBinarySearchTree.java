package src.Leetcode;

public class RecoverBinarySearchTree {

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Range {
    TreeNode low, high;

    Range(TreeNode l, TreeNode h) {
        low = l;
        high = h;
    }

    Range smallerThan(TreeNode node) {
        return new Range(low, node);
    }

    Range greaterThan(TreeNode node) {
        return new Range(node, high);
    }
}

class Solution {
    void swapVals(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    boolean recursiveFindMistake(TreeNode root, Range range) {
        if (root == null)
            return false;

        if (root.val < range.low.val) {
            swapVals(range.low, root);
            return true;
        }
        if (root.val > range.high.val) {
            swapVals(range.high, root);
            return true;
        }

        if (recursiveFindMistake(root.left, range.smallerThan(root)))
            return true;
        if (recursiveFindMistake(root.right, range.greaterThan(root)))
            return true;

        return false;
    }

    public void recoverTree(TreeNode root) {
        while (
            recursiveFindMistake(
                root,
                new Range(
                    new TreeNode(Integer.MIN_VALUE), 
                    new TreeNode(Integer.MAX_VALUE)
                )
            )
        ) {
        }
    }
}
