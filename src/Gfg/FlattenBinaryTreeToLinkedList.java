package src.Gfg;

public class FlattenBinaryTreeToLinkedList {

}

class Solution {
    public static void flatten(Node root) {
        new Solution().recursiveJoinLinks(root);
    }

    Node prevNode = null;

    private void recursiveJoinLinks(Node node) {
        if (node == null)
            return;

        Node nodeLeft = node.left, nodeRight = node.right;
        if (prevNode != null) {
            prevNode.right = node;
            prevNode.left = null;
        }
        prevNode = node;
        recursiveJoinLinks(nodeLeft);
        recursiveJoinLinks(nodeRight);
    }
}
