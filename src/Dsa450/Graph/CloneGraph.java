package src.Dsa450.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Node finalNode = new Node();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        HashMap<Node, Node> nodeRecord = new HashMap<>();
        nodeRecord.put(node, finalNode);

        Node originalNode;
        while ((originalNode = nodeQueue.poll()) != null) {
            Node clonedNode = nodeRecord.get(originalNode);
            clonedNode.val = originalNode.val;

            for (Node neighbourNode : originalNode.neighbors) {
                Node clonedNeighbourNode = nodeRecord.get(neighbourNode);
                if (clonedNeighbourNode == null) {
                    Node newNode = new Node();
                    nodeQueue.offer(neighbourNode);
                    clonedNode.neighbors.add(newNode);
                    nodeRecord.put(neighbourNode, newNode);
                } else
                    clonedNode.neighbors.add(clonedNeighbourNode);
            }
        }

        return finalNode;
    }
}
