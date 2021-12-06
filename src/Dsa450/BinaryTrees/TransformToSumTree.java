package src.Dsa450.BinaryTrees;

public class TransformToSumTree {

}

class Solution {
    public void toSumTree(Node root) {
        recurivseSumOfChildNodes(root);
    }

    private int recurivseSumOfChildNodes(Node node) {
        if (node == null)
            return 0;

        int childNodesSum = recurivseSumOfChildNodes(node.left) + recurivseSumOfChildNodes(node.right);
        int nodeData = node.data;
        node.data = childNodesSum;
        return childNodesSum + nodeData;
    }
}
