package src.Dsa450.Trie;

import java.util.ArrayList;

public class UniqueRowsInBooleanMatrix {

}

class GfG {
    private static class BinaryTrieNode {
        boolean isEnd;
        BinaryTrieNode[] children = new BinaryTrieNode[2];
    }

    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        BinaryTrieNode root = new BinaryTrieNode();

        for (int i = 0; i < r; ++i) {
            BinaryTrieNode currNode = root;
            for (int j = 0; j < c; ++j) {
                if (currNode.children[a[i][j]] == null)
                    currNode.children[a[i][j]] = new BinaryTrieNode();
                currNode = currNode.children[a[i][j]];
            }
            if (!currNode.isEnd) {
                ArrayList<Integer> list = new ArrayList<>(c);
                for (int j = 0; j < c; ++j)
                    list.add(a[i][j]);
                result.add(list);
            }
            currNode.isEnd = true;
        }
        return result;
    }
}
