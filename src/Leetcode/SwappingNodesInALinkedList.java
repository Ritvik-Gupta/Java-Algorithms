package src.Leetcode;

public class SwappingNodesInALinkedList {

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int listSize = 1;

        ListNode node = head;
        int idx = 1;
        ListNode firstNode = null;
        while (node != null) {
            if (idx == k)
                firstNode = node;
            idx++;
            listSize++;
            node = node.next;
        }

        int kFromLast = listSize - k;

        node = head;
        idx = 1;
        while (node != null) {
            if (idx == kFromLast)
                break;
            idx++;
            node = node.next;
        }

        ListNode secondNode = node;

        int temp = secondNode.val;
        secondNode.val = firstNode.val;
        firstNode.val = temp;

        return head;
    }
}
