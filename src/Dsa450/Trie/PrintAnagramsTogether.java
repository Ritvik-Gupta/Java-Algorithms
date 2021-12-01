package src.Dsa450.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PrintAnagramsTogether {
}

class Solution {
    private static final char OFFSET = 'a';

    private static class TrieNode {
        List<String> store;
        TrieNode[] children = new TrieNode[26];
    }

    private static TreeMap<Character, Integer> charFrequencies(String word) {
        TreeMap<Character, Integer> frequencies = new TreeMap<>();
        for (int i = 0; i < word.length(); ++i) {
            frequencies.putIfAbsent(word.charAt(i), 0);
            frequencies.compute(word.charAt(i), (__, freq) -> freq + 1);
        }
        return frequencies;
    }

    public List<List<String>> Anagrams(String[] stringList) {
        List<List<String>> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (String word : stringList) {
            TreeMap<Character, Integer> frequencies = charFrequencies(word);

            TrieNode currNode = root;
            for (Character character : frequencies.keySet()) {
                int offsetChild = character - OFFSET, frequency = frequencies.get(character);
                for (int j = 0; j < frequency; ++j, currNode = currNode.children[offsetChild])
                    if (currNode.children[offsetChild] == null)
                        currNode.children[offsetChild] = new TrieNode();
            }

            if (currNode.store == null) {
                ArrayList<String> anagramList = new ArrayList<>();
                result.add(anagramList);
                currNode.store = anagramList;
            }
            currNode.store.add(word);
        }

        return result;
    }
}
