package src.Dsa450.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ZigZagTreeTraversal {

}

class GFG {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Node> levelStack, nextLevelStack = new ArrayDeque<>();
        nextLevelStack.addLast(root);
        boolean isEvenLevel = false;

        while (!nextLevelStack.isEmpty()) {
            isEvenLevel = !isEvenLevel;
            levelStack = nextLevelStack;
            nextLevelStack = new LinkedList<>();

            Node node;
            while (!levelStack.isEmpty()) {
                if ((node = levelStack.pollLast()) == null)
                    continue;

                result.add(node.data);
                nextLevelStack.addAll(
                    isEvenLevel 
                    ? Arrays.asList(node.left, node.right) 
                    : Arrays.asList(node.right, node.left)
                );
            }
        }

        return result;
    }
}
