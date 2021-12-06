package src.Dsa450.LinkedList;

public class DetectLoopInLinkedList {
}

class Solution {
    public static boolean detectLoop(Node head) {
        Node turtle = head, rabbit = head;
        while (rabbit.next != null && rabbit.next.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit)
                return true;
        }
        return false;
    }
}
