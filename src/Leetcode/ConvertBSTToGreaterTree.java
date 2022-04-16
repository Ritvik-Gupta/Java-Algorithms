package src.Leetcode;

public class ConvertBSTToGreaterTree {
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
    private int updateToGreaterNode(TreeNode node, int parentSumValue) {
        if (node == null)
            return parentSumValue;

        node.val += updateToGreaterNode(node.right, parentSumValue);
        return updateToGreaterNode(node.left, node.val);
    }

    public TreeNode convertBST(TreeNode root) {
        updateToGreaterNode(root, 0);
        return root;
    }
}
