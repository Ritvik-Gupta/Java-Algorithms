package src.Dsa450.BinaryTrees;

public class SumOfTheLongestBloodlineOfATree {

}

class Solution {
    public int sumOfLongRootToLeafPath(Node root) {
        return recursiveLongestSumPath(root, 0).sum;
    }

    private static final SumAtDepth NULL_NODE = new SumAtDepth(-1, -1);

    private SumAtDepth recursiveLongestSumPath(Node node, int depth) {
        if (node == null)
            return NULL_NODE;

        if (node.left == null && node.right == null)
            return new SumAtDepth(node.data, depth);

        SumAtDepth left = recursiveLongestSumPath(node.left, depth + 1),
                right = recursiveLongestSumPath(node.right, depth + 1);

        SumAtDepth result = new SumAtDepth(node.data, Math.max(left.depth, right.depth));

        result.sum += (left.depth > right.depth)
                ? left.sum
                : (left.depth < right.depth)
                        ? right.sum
                        : Math.max(left.sum, right.sum);

        return result;
    }

    private static class SumAtDepth {
        int sum, depth;

        SumAtDepth(int sum, int depth) {
            this.sum = sum;
            this.depth = depth;
        }
    }
}
