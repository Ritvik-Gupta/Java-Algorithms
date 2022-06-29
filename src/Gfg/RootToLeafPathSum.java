package src.Gfg;

public class RootToLeafPathSum {

}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    boolean hasPathSum(Node root, int sum) {
        if (root == null)
            return false;
        if (sum < 0)
            return false;
        if (root.left == null && root.right == null)
            return root.data == sum;

        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }
}
