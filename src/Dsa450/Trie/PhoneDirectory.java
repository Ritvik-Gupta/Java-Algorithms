package src.Dsa450.Trie;

import java.util.ArrayList;
import java.util.List;

public class PhoneDirectory {

}

class Solution {
    private static class TrieNode {
        String store;
        TrieNode[] children = new TrieNode[26];
    }

    private static final char OFFSET = 'a';
    private static final ArrayList<String> NO_MATCH = new ArrayList<>() {
        {
            add("0");
        }
    };

    static ArrayList<ArrayList<String>> displayContacts(int _n, String contacts[], String searchStr) {
        final TrieNode ROOT_NODE = new TrieNode();
        ArrayList<ArrayList<String>> result = new ArrayList<>(searchStr.length());

        for (String contact : contacts) {
            TrieNode currNode = ROOT_NODE;
            for (int i = 0; i < contact.length(); ++i) {
                int offsetChild = contact.charAt(i) - OFFSET;
                if (currNode.children[offsetChild] == null)
                    currNode.children[offsetChild] = new TrieNode();
                currNode = currNode.children[offsetChild];
            }
            currNode.store = contact;
        }

        TrieNode currNode = ROOT_NODE;
        for (int i = 0; i < searchStr.length(); ++i) {
            int offsetChild = searchStr.charAt(i) - OFFSET;
            if (currNode != null)
                currNode = currNode.children[offsetChild];

            ArrayList<String> matchResults = new ArrayList<>();
            recursiveFindMatch(currNode, matchResults);
            result.add(matchResults.size() == 0 ? NO_MATCH : matchResults);
        }

        return result;
    }

    private static void recursiveFindMatch(TrieNode rootNode, List<String> matchResults) {
        if (rootNode == null)
            return;

        if (rootNode.store != null)
            matchResults.add(rootNode.store);
        for (TrieNode childNode : rootNode.children)
            recursiveFindMatch(childNode, matchResults);
    }
}
