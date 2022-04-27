package src.Dsa450.LinkedList;

import java.util.PriorityQueue;

public class FlatteningALinkedList {

}

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

class GfG {
    Node flatten(Node root) {
        PriorityQueue<Node> nodeQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.data, b.data));
        for (Node curr = root; curr != null; curr = curr.next)
            nodeQueue.offer(curr);

        Node newRoot = new Node(0);
        Node curr = newRoot;
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            curr = curr.bottom = node;

            if (node.bottom != null)
                nodeQueue.offer(node.bottom);
        }

        return newRoot.bottom;
    }
}
