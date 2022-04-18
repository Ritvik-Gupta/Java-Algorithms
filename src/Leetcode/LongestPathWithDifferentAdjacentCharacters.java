package src.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestPathWithDifferentAdjacentCharacters {

}

class NodePath {
    int length, depth;

    NodePath(int l, int d) {
        length = l;
        depth = d;
    }
}

class TreeNode {
    char symbol;
    NodePath path = null;
    ArrayList<TreeNode> children = new ArrayList<>();

    TreeNode(char s) {
        symbol = s;
    }
}

class Solution {
    void recursiveNodePaths(TreeNode root) {
        root.children.stream().parallel().forEach(this::recursiveNodePaths);

        TreeNode maxDepthChildNode = root.children.stream().parallel()
                .max((a, b) -> Integer.compare(a.path.depth, b.path.depth))
                .get();

        root.children.stream().parallel().filter(childNode -> childNode.symbol != root.symbol)
                .sorted((a, b) -> Integer.compare(a.path.length, b.path.length));

        return;
    }

    TreeNode createTree(int[] parents, String symbols) {
        HashMap<Integer, TreeNode> directory = new HashMap<>(parents.length + 1);
        directory.put(-1, new TreeNode('#'));
        for (int idx = 0; idx < parents.length; ++idx)
            directory.put(idx, new TreeNode(symbols.charAt(idx)));

        for (int idx = 0; idx < parents.length; ++idx)
            directory.get(parents[idx]).children.add(directory.get(idx));

        return directory.get(0);
    }

    public int longestPath(int[] parents, String symbols) {
        TreeNode root = createTree(parents, symbols);
        recursiveNodePaths(root);
        return root.path.length;
    }
}
