package src.Leetcode;

import java.util.ArrayDeque;

public class BinarySearchTreeIterator {

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

class BSTIterator {

    ArrayDeque<TreeNode> stackFrames;

    public BSTIterator(TreeNode root) {
        stackFrames = new ArrayDeque<>();
        addLeftIteratively(root);
    }

    private void addLeftIteratively(TreeNode root) {
        while (root != null) {
            stackFrames.addLast(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode stateNode = stackFrames.removeLast();
        addLeftIteratively(stateNode.right);
        return stateNode.val;
    }

    public boolean hasNext() {
        return !stackFrames.isEmpty();
    }
}
