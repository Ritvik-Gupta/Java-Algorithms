package src.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class WordLadder {
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLength = beginWord.length();

        GraphNode[] nodes = new GraphNode[wordList.size() + 1];
        nodes[0] = new GraphNode(beginWord);

        int endWordPos = -1;
        for (int i = 0; i < wordList.size(); ++i) {
            nodes[i + 1] = new GraphNode(wordList.get(i));
            if (endWord.equals(wordList.get(i)))
                endWordPos = i + 1;
        }

        if (endWordPos == -1)
            return 0;

        for (int i = 0; i < nodes.length; ++i)
            for (int j = i + 1; j < nodes.length; ++j)
                if (computeSimilarity(nodes[i].wordId, nodes[j].wordId) == wordLength - 1) {
                    nodes[i].links.add(nodes[j]);
                    nodes[j].links.add(nodes[i]);
                }

        return performBfs(nodes, endWordPos);
    }

    private int performBfs(GraphNode[] nodes, int endWordPos) {
        String endWord = nodes[endWordPos].wordId;

        Queue<GraphNode> nodeQueue = new ArrayDeque<>();
        HashSet<GraphNode> visitedNodes = new HashSet<>();
        Queue<Integer> nodeDistQueue = new ArrayDeque<>();

        nodeQueue.offer(nodes[0]);
        visitedNodes.add(nodes[0]);
        nodeDistQueue.offer(1);

        while (!nodeQueue.isEmpty()) {
            GraphNode node = nodeQueue.poll();
            Integer nodeDist = nodeDistQueue.poll();

            if (endWord.equals(node.wordId))
                return nodeDist;

            node.links.forEach(neighborNode -> {
                if (!visitedNodes.contains(neighborNode)) {
                    nodeQueue.offer(neighborNode);
                    visitedNodes.add(neighborNode);
                    nodeDistQueue.offer(nodeDist + 1);
                }
            });
        }

        return 0;
    }

    private int computeSimilarity(String word1, String word2) {
        if (word1.length() != word2.length())
            throw new Error();

        int similarCount = 0;
        for (int i = 0; i < word1.length(); ++i)
            if (word1.charAt(i) == word2.charAt(i))
                ++similarCount;

        return similarCount;
    }
}

class GraphNode {
    String wordId;
    List<GraphNode> links = new ArrayList<>();

    GraphNode(String wordId) {
        this.wordId = wordId;
    }
}
