package src.Gfg;

public class ConnectNodesAtSameLevel {

}

class Node {
    int data;
    Node left;
    Node right;
    Node nextRight;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
        nextRight = null;
    }
}

class Solution {
    final Node BUFFER_NODE = new Node(-1);

    public void connect(Node root) {
        Node prevCursor = root;

        while (prevCursor != null) {
            Node cursor = BUFFER_NODE;
            while (prevCursor != null) {
                if (prevCursor.left != null) {
                    cursor.nextRight = prevCursor.left;
                    cursor = cursor.nextRight;
                }
                if (prevCursor.right != null) {
                    cursor.nextRight = prevCursor.right;
                    cursor = cursor.nextRight;
                }

                prevCursor = prevCursor.nextRight;
            }
            prevCursor = BUFFER_NODE.nextRight;
            BUFFER_NODE.nextRight = null;
        }
    }
}
