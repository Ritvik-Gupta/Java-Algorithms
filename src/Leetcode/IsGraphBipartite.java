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

    boolean dfsBipartition(int nodeIdx, Color color) {
        nodeColor[nodeIdx] = color;
        for (int linkIdx : adjacencyList[nodeIdx])
            if (
                (nodeColor[linkIdx] == null && !dfsBipartition(linkIdx, color.flip()))
                || nodeColor[linkIdx] == nodeColor[nodeIdx]
            )
                return false;
        return true;
    }
}

class Solution {
    public boolean isBipartite(int[][] adjacencyList) {
        Graph graph = new Graph(adjacencyList);
        for (int i = 0; i < adjacencyList.length; ++i)
            if (graph.nodeColor[i] == null && !graph.dfsBipartition(i, Color.BLUE))
                return false;
        return true;
    }
}
