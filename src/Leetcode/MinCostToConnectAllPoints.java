package src.Leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

}

class WeightedEdge implements Comparable<WeightedEdge> {
    int weight;
    int vertexId;

    WeightedEdge(int v, int w) {
        vertexId = v;
        weight = w;
    }

    @Override
    public int compareTo(WeightedEdge other) {
        return Integer.compare(weight, other.weight);
    }
}

class Solution {
    private int manhatten(int[] pointA, int[] pointB) {
        return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] adjacencyMatrix = new int[n][n];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                adjacencyMatrix[i][j] = manhatten(points[i], points[j]);

        HashSet<Integer> visitedVertices = new HashSet<>();
        visitedVertices.add(0);
        PriorityQueue<WeightedEdge> mstEdges = new PriorityQueue<>(n);
        for (int i = 0; i < n; ++i)
            mstEdges.offer(new WeightedEdge(i, adjacencyMatrix[0][i]));

        int totalMstWeight = 0;
        while (!mstEdges.isEmpty()) {
            WeightedEdge edge = mstEdges.poll();
            if (!visitedVertices.add(edge.vertexId))
                continue;

            totalMstWeight += edge.weight;
            for (int i = 0; i < n; ++i)
                mstEdges.offer(new WeightedEdge(i, adjacencyMatrix[edge.vertexId][i]));
        }

        return totalMstWeight;
    }
}
