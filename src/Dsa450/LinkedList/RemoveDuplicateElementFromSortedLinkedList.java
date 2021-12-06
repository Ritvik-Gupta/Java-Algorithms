
package src.Dsa450.LinkedList;

public class RemoveDuplicateElementFromSortedLinkedList {
}

class GfG {
    Node removeDuplicates(Node head) {
        Node currNode = head;
        while (currNode.next != null)
            if (currNode.data == currNode.next.data)
                currNode.next = currNode.next.next;
            else
                currNode = currNode.next;

        return head;
    }
}
