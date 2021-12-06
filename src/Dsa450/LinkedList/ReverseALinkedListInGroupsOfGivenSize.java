package src.Dsa450.LinkedList;

public class ReverseALinkedListInGroupsOfGivenSize {

}

class Solution {
    public static Node reverse(Node head, int k) {
        if (head == null)
            return null;

        Node prevNode = null, currNode = head;
        int i = 0;

        for (; i < k && currNode != null; i++) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = reverse(currNode, k);
        return prevNode;
    }
}
