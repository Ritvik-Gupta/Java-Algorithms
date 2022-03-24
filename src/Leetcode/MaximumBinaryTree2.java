package src.Leetcode;

public class MaximumBinaryTree2 {

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
    private static final int NODE_MIN_VAL = 0;

    private int getNullableNodeVal(TreeNode node) {
        return node == null ? NODE_MIN_VAL : node.val;
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        root = new TreeNode(Integer.MAX_VALUE, null, root);

        TreeNode valNode = new TreeNode(val);

        TreeNode parentNode = root;
        TreeNode currentNode = root.right;
        while (true) {
            if (getNullableNodeVal(currentNode) < valNode.val) {
                parentNode.right = valNode;
                valNode.left = currentNode;
                return root.right;
            }

            parentNode = currentNode;
            currentNode = currentNode.right;
        }
    }
}
