package src;

import java.util.Scanner;

public class SolutionClass {
    private static final LinkedNode HEAD_NODE = new LinkedNode(-1);

    private static class LinkedNode {
        int store;
        LinkedNode next, prev;

        LinkedNode(int store) {
            this.store = store;
        }
    }

    private static void evictNode(LinkedNode node) {
        if (node == null || node == HEAD_NODE)
            return;

        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
    }

    private static LinkedNode findMinNode() {
        LinkedNode currNode = HEAD_NODE.next, minNode = HEAD_NODE.next;
        while (currNode != null) {
            if (currNode.store < minNode.store)
                minNode = currNode;
            currNode = currNode.next;
        }
        return minNode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedNode currNode = HEAD_NODE;
        for (int i = 0; i < n; ++i) {
            currNode.next = new LinkedNode(sc.nextInt());
            currNode.next.prev = currNode;
            currNode = currNode.next;
        }

        int result = 0;
        while (HEAD_NODE.next != null) {
            LinkedNode minNode = findMinNode();
            result += minNode.store;
            evictNode(minNode.prev);
            evictNode(minNode.next);
            evictNode(minNode);
        }

        System.out.println(result);

        sc.close();
    }
}
