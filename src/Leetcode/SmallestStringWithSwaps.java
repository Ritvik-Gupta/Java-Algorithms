package src.Leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestStringWithSwaps {
}

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind clusters = new UnionFind(s.length());

        for (List<Integer> edge : pairs)
            clusters.union(edge.get(0), edge.get(1));

        Map<Integer, PriorityQueue<Character>> clusterComponents = new HashMap<>();
        for (int vertex = 0; vertex < s.length(); ++vertex) {
            int root = clusters.find(vertex);

            clusterComponents.putIfAbsent(root, new PriorityQueue<>());
            clusterComponents.get(root).offer(s.charAt(vertex));
        }

        StringBuilder smallestString = new StringBuilder(s.length());
        for (int vertex = 0; vertex < s.length(); ++vertex)
            smallestString.append(clusterComponents.get(clusters.find(vertex)).poll());
        return smallestString.toString();
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int vertex) {
        if (vertex == root[vertex])
            return vertex;
        return root[vertex] = find(root[vertex]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)
            return;

        if (rank[rootX] >= rank[rootY]) {
            root[rootY] = rootX;
            rank[rootX] += rank[rootY];
        } else {
            root[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }

    }
}
