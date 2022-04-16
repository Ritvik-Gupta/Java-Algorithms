package src.Dsa450.Heap;

import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

}

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    Node mergeKList(Node[] arr, int k) {
        PriorityQueue<Node> nodesMinHeap = new PriorityQueue<>(k + 1, (a, b) -> {
            Integer dataA = a.data, dataB = b.data;
            return dataA.compareTo(dataB);
        });
        Node result = new Node(0);

        for (Node headNode : arr)
            nodesMinHeap.offer(headNode);

        Node currNode = result;
        while (!nodesMinHeap.isEmpty()) {
            Node node = nodesMinHeap.poll();

            currNode.next = node;
            currNode = currNode.next;

            if (node.next != null)
                nodesMinHeap.offer(node.next);
        }

        return result.next;
    }
}
