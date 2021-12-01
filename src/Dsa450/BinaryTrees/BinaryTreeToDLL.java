package src.Dsa450.BinaryTrees;

public class BinaryTreeToDLL {
}

class Solution {
    Node bToDLL(Node root) {
        return recursiveJoinLinks(root).leftMost;
    }

    private ExtremeNodeEnds recursiveJoinLinks(Node node) {
        ExtremeNodeEnds result = new ExtremeNodeEnds();
        
        if (node.left == null)
            result.leftMost = node;
        else {
            ExtremeNodeEnds leftExtremeEnds = recursiveJoinLinks(node.left);
            node.left = leftExtremeEnds.rightMost;
            leftExtremeEnds.rightMost.right = node;
            result.leftMost = leftExtremeEnds.leftMost;
        }

        if (node.right == null)
            result.rightMost = node;
        else {
            ExtremeNodeEnds rightExtremeEnds = recursiveJoinLinks(node.right);
            node.right = rightExtremeEnds.leftMost;
            rightExtremeEnds.leftMost.left = node;
            result.rightMost = rightExtremeEnds.rightMost;
        }

        return result;
    }

    private static class ExtremeNodeEnds {
        Node leftMost, rightMost;
    }
}
