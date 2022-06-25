package src.AmazonChallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SpecialEdge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numNodes = sc.nextInt();
        int numEdges = sc.nextInt();

        ArrayList<HashSet<Integer>> adjacencyList = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; ++i)
            adjacencyList.add(new HashSet<>());

        for (int i = 0; i < numEdges; ++i) {
            int nodeA = sc.nextInt() - 1, nodeB = sc.nextInt() - 1;
            adjacencyList.get(nodeA).add(nodeB);
            adjacencyList.get(nodeB).add(nodeA);
        }

        sc.close();

        ArrayList<int[]> bridgeEdges = Bridges.inGraph(numNodes, adjacencyList);
        for (int[] bridge : bridgeEdges)
            System.out.println(bridge[0] + "\t" + bridge[1]);

        for (int[] bridge : bridgeEdges) {
            adjacencyList.get(bridge[0]).remove(bridge[1]);
            adjacencyList.get(bridge[1]).remove(bridge[0]);
        }
    }
}

class Bridges {
    HashSet<Integer> visited;
    int[] disc, low;
    Integer[] parent;
    int time;

    Bridges(int numNodes) {
        visited = new HashSet<>(numNodes);
        disc = new int[numNodes];
        low = new int[numNodes];
        parent = new Integer[numNodes];
        time = 0;

    }

    static ArrayList<int[]> inGraph(int numNodes, ArrayList<HashSet<Integer>> adjacencyList) {
        Bridges bridgeBuilder = new Bridges(numNodes);

        ArrayList<int[]> bridges = new ArrayList<>();
        for (int i = 0; i < numNodes; ++i) {
            if (!bridgeBuilder.visited.contains(i)) {
                bridgeBuilder.recrBuildFromNode(i, adjacencyList, bridges);
            }
        }
        return bridges;
    }

    void recrBuildFromNode(int node, ArrayList<HashSet<Integer>> adjacencyList, ArrayList<int[]> bridges) {
        visited.add(node);

        time += 1;
        low[node] = time;
        disc[node] = time;

        for (int neighborNode : adjacencyList.get(node)) {
            if (!visited.contains(neighborNode)) {
                parent[neighborNode] = node;
                recrBuildFromNode(neighborNode, adjacencyList, bridges);

                low[node] = Math.min(low[node], low[neighborNode]);
                if (low[neighborNode] > disc[node])
                    bridges.add(new int[] { node, neighborNode });

            } else if (neighborNode != parent[node]) {
                low[node] = Math.min(low[node], disc[neighborNode]);
            }
        }
    }
}
