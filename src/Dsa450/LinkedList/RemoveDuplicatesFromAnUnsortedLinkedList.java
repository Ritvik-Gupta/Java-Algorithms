package src.Dsa450.LinkedList;

import java.util.HashSet;

public class RemoveDuplicatesFromAnUnsortedLinkedList {
}

class Solution {
    public Node removeDuplicates(Node head) {
        HashSet<Integer> visitedNodeValues = new HashSet<>();
        visitedNodeValues.add(head.data);

        Node currNode = head;
        while (currNode.next != null) {
            if (!visitedNodeValues.add(currNode.next.data)) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }

        return head;
    }
}
