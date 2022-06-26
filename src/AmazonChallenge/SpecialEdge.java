package src.AmazonChallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

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

        Bridges bridgeBuilder = new Bridges(numNodes, adjacencyList);

        boolean[] stackMember = new boolean[numNodes];
        Stack<Integer> stack = new Stack<>();

        ArrayList<int[]> bridges = new ArrayList<>();
        int[] belongingClusterSizes = new int[numNodes];
        for (int i = 0; i < numNodes; ++i)
            if (bridgeBuilder.disc[i] == -1)
                bridgeBuilder.recrBuildFromNode(i, stackMember, stack, belongingClusterSizes, bridges);

        long result = 0;
        for (int[] bridge : bridges)
            result += (long) belongingClusterSizes[bridge[0]] * (long) belongingClusterSizes[bridge[1]];

        System.out.println(result);
    }
}

class Bridges {
    ArrayList<HashSet<Integer>> adjacencyList;
    int[] disc, low;
    Integer[] parent;
    int time;

    Bridges(int numNodes, ArrayList<HashSet<Integer>> adj) {
        adjacencyList = adj;
        disc = new int[numNodes];
        low = new int[numNodes];

        for (int i = 0; i < numNodes; ++i) {
            disc[i] = -1;
            low[i] = -1;
        }

        parent = new Integer[numNodes];
        time = 0;

    }

    void recrBuildFromNode(int node, boolean[] stackMember, Stack<Integer> stack, int[] belongingClusterSizes,
            ArrayList<int[]> bridges) {
        low[node] = time;
        disc[node] = time;
        time += 1;
        stackMember[node] = true;
        stack.push(node);

        for (int neighborNode : adjacencyList.get(node)) {
            if (disc[neighborNode] == -1) {
                parent[neighborNode] = node;
                recrBuildFromNode(neighborNode, stackMember, stack, belongingClusterSizes, bridges);

                low[node] = Math.min(low[node], low[neighborNode]);
                if (low[neighborNode] > disc[node])
                    bridges.add(new int[] { node, neighborNode });

            } else if (stackMember[neighborNode] && parent[node] != null && neighborNode != parent[node]) {
                low[node] = Math.min(low[node], disc[neighborNode]);
            }
        }

        if (low[node] == disc[node]) {
            int clusterSize = 0;
            int stackNode = -1;

            ArrayList<Integer> clusterNodes = new ArrayList<>();
            while (stackNode != node) {
                stackNode = stack.pop();
                stackMember[stackNode] = false;
                clusterNodes.add(stackNode);
                ++clusterSize;
            }

            for (int clusterNode : clusterNodes)
                belongingClusterSizes[clusterNode] = clusterSize;
        }
    }
}
