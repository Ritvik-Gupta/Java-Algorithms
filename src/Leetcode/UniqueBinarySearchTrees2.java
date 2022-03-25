package src.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
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
    private static void cloneTree(TreeNode root, TreeNode rootClone) {
        rootClone.val = root.val;

        if (root.left != null) {
            rootClone.left = new TreeNode();
            cloneTree(root.left, rootClone.left);
        }

        if (root.right != null) {
            rootClone.right = new TreeNode();
            cloneTree(root.right, rootClone.right);
        }
    }

    private List<TreeNode> recursePossibleBSTs(int startNum, int endNum) {
        List<TreeNode> possibleBSTs = new ArrayList<>();

        for (int num = startNum; num <= endNum; ++num) {
            TreeNode root = new TreeNode(num);

            List<TreeNode> leftHalfBSTs = recursePossibleBSTs(startNum, num - 1);
            if (leftHalfBSTs.size() == 0)
                leftHalfBSTs.add(null);

            List<TreeNode> rightHalfBSTs = recursePossibleBSTs(num + 1, endNum);
            if (rightHalfBSTs.size() == 0)
                rightHalfBSTs.add(null);

            for (TreeNode leftNode : leftHalfBSTs) {
                root.left = leftNode;
                for (TreeNode rightNode : rightHalfBSTs) {
                    root.right = rightNode;

                    TreeNode rootClone = new TreeNode();
                    cloneTree(root, rootClone);
                    possibleBSTs.add(rootClone);
                }
            }
        }

        return possibleBSTs;
    }

    public List<TreeNode> generateTrees(int n) {
        return recursePossibleBSTs(1, n);
    }
}
