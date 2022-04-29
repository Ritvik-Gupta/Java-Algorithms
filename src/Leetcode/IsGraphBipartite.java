package src.Leetcode;

public class IsGraphBipartite {
}

enum Color {
    BLUE, GREEN;

    Color flip() {
        return this == BLUE ? GREEN : BLUE;
    }
}

class Graph {
    int[][] adjacencyList;
    Color[] nodeColor;

    Graph(int[][] a) {
        adjacencyList = a;
        nodeColor = new Color[adjacencyList.length];
    }

    boolean dfsThroughBipartition(int nodeIdx, Color color) {
        nodeColor[nodeIdx] = color;
        for (int linkIdx : adjacencyList[nodeIdx])
            if (nodeColor[linkIdx] == nodeColor[nodeIdx])
                return false;
            else if (nodeColor[linkIdx] == null && !dfsThroughBipartition(linkIdx, color.flip()))
                return false;
        return true;
    }
}

class Solution {
    public boolean isBipartite(int[][] adjacencyList) {
        Graph graph = new Graph(adjacencyList);
        for (int i = 0; i < adjacencyList.length; ++i)
            if (graph.nodeColor[i] == null && !graph.dfsThroughBipartition(i, Color.BLUE))
                return false;
        return true;
    }
}
