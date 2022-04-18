package src.Dsa450.BST;

public class CheckWhetherBSTContainsDeadEnd {

}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class GFG {
    static class Range {
        int low, high;

        Range(int l, int h) {
            low = l;
            high = h;
        }

        Range lowerThan(int num) {
            return new Range(low, num);
        }

        Range higherThan(int num) {
            return new Range(num, high);
        }
    }

    static boolean recursiveIsDeadEnd(Node root, Range range) {
        if (root.left == null && root.right == null)
            return range.low + 2 >= range.high;

        if (root.left != null)
            if (recursiveIsDeadEnd(root.left, range.lowerThan(root.data)))
                return true;

        if (root.right != null)
            if (recursiveIsDeadEnd(root.right, range.higherThan(root.data)))
                return true;

        return false;
    }

    public static boolean isDeadEnd(Node root) {
        return recursiveIsDeadEnd(root, new Range(0, Integer.MAX_VALUE));
    }
}
