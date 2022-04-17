package src.Leetcode;

public class IncreasingOrderSearchTree {
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

class Solution {
    private TreeNode updateToInorderNode(TreeNode root, TreeNode sentinal) {
        if (root == null)
            return sentinal;

        sentinal = updateToInorderNode(root.left, sentinal);
        sentinal.right = root;
        root.left = null;
        sentinal = root;
        return updateToInorderNode(root.right, sentinal);
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyRoot = new TreeNode();
        updateToInorderNode(root, dummyRoot);
        return dummyRoot.right;
    }
}
