package src.Dsa450.BinaryTrees;

import java.util.HashMap;

public class LowestCommonAncestorInABinaryTree {

}

class Solution {
    Node lca(Node root, int nodeAData, int nodeBData) {
        HashMap<Integer, NodeDetails> parentRecords = new HashMap<>();
        parentRecords.put(root.data, new NodeDetails(0, root, null));
        recursiveSearch(root, 1, parentRecords);

        NodeDetails entryA = parentRecords.get(nodeAData), entryB = parentRecords.get(nodeBData);
        while (true) {
            if (entryA.node.data == entryB.node.data)
                return entryA.node;

            NodeDetails newEntryA = entryA, newEntryB = entryB;
            if (entryA.depth <= entryB.depth)
                newEntryB = parentRecords.get(entryB.parentNode.data);
            if (entryA.depth >= entryB.depth)
                newEntryA = parentRecords.get(entryA.parentNode.data);

            entryA = newEntryA;
            entryB = newEntryB;
        }
    }

    private static class NodeDetails {
        int depth;
        Node node, parentNode;

        NodeDetails(int depth, Node node, Node parentNode) {
            this.depth = depth;
            this.node = node;
            this.parentNode = parentNode;
        }
    }

    private void recursiveSearch(Node node, int depth, HashMap<Integer, NodeDetails> parentRecords) {
        if (node.left != null) {
            parentRecords.put(node.left.data, new NodeDetails(depth, node.left, node));
            recursiveSearch(node.left, depth + 1, parentRecords);
        }
        if (node.right != null) {
            parentRecords.put(node.right.data, new NodeDetails(depth, node.right, node));
            recursiveSearch(node.right, depth + 1, parentRecords);
        }
    }
}
