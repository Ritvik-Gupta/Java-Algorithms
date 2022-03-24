package src.Dsa450.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BoundaryTraversalOfBinaryTree {

}

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> boundaryNodes = new ArrayList<>();
        boundaryNodes.add(root.data);

        if (root.left == null && root.right == null)
            return boundaryNodes;

        Node leftNode = root.left;
        while (leftNode != null) {
            if (leftNode.left != null || leftNode.right != null)
                boundaryNodes.add(leftNode.data);
            leftNode = leftNode.left != null ? leftNode.left : leftNode.right;
        }

        ArrayDeque<Node> nodeStack = new ArrayDeque<>();
        nodeStack.add(root);

        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();

            if (node.left == null && node.right == null)
                boundaryNodes.add(node.data);

            if (node.right != null)
                nodeStack.push(node.right);
            if (node.left != null)
                nodeStack.push(node.left);
        }

        ArrayDeque<Integer> rightHalfStack = new ArrayDeque<>();

        Node rightNode = root.right;
        while (rightNode != null) {
            if (rightNode.left != null || rightNode.right != null)
                rightHalfStack.push(rightNode.data);
            rightNode = rightNode.right != null ? rightNode.right
                    : rightNode.left;
        }

        while (!rightHalfStack.isEmpty())
            boundaryNodes.add(rightHalfStack.pop());

        return boundaryNodes;
    }
}
