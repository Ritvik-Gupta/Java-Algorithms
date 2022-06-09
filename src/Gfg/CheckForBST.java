package src.Gfg;

public class CheckForBST {
}

class Node {
    int data;
    Node left = null, right = null;

    Node(int d) {
        data = d;
    }
}

class Solution {
    static class NodeLimits {
        int lowest, highest;
    }

    static NodeLimits checkForBstLimits(Node root) {
        NodeLimits limits = new NodeLimits();

        if (root.left == null)
            limits.lowest = root.data;
        else {
            NodeLimits leftLimits = checkForBstLimits(root.left);
            if (leftLimits == null || leftLimits.highest > root.data)
                return null;
            limits.lowest = leftLimits.lowest;
        }

        if (root.right == null)
            limits.highest = root.data;
        else {
            NodeLimits rightLimits = checkForBstLimits(root.right);
            if (rightLimits == null || rightLimits.lowest < root.data)
                return null;
            limits.highest = rightLimits.highest;
        }

        return limits;
    }

    boolean isBST(Node root) {
        return checkForBstLimits(root) != null;
    }
}
