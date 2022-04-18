package src.Leetcode;

public class KthSmallestElementInABST {
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
    static class KIntResult {
        int kIdx, value = -1;

        KIntResult(int k) {
            kIdx = k;
        }
    }

    private int recursiveNodeIndex(TreeNode node, int prevIdx, KIntResult result) {
        if (node == null)
            return prevIdx;

        int leftIdx = recursiveNodeIndex(node.left, prevIdx, result);
        if (leftIdx == -1)
            return -1;

        int currIdx = leftIdx + 1;
        if (currIdx == result.kIdx) {
            result.value = node.val;
            return -1;
        }

        int rightIdx = recursiveNodeIndex(node.right, currIdx, result);
        if (rightIdx == -1)
            return -1;

        return rightIdx;
    }

    public int kthSmallest(TreeNode root, int k) {
        KIntResult res = new KIntResult(k);
        recursiveNodeIndex(root, 0, res);
        return res.value;
    }
}
