package src.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {

}

class Node {
    List<Edge> outLinks = new ArrayList<>();

    Double dfsToFind(Node toFindNode, HashSet<Node> hasVisited) {
        if (this == toFindNode)
            return 1.0;

        hasVisited.add(this);
        for (Edge edge : outLinks) {
            if (hasVisited.contains(edge.linkTo))
                continue;

            Double resultFromLink = edge.linkTo.dfsToFind(toFindNode, hasVisited);
            if (resultFromLink != null)
                return edge.weight * resultFromLink;
        }
        hasVisited.remove(this);

        return null;
    }
}

class Edge {
    Node linkTo;
    double weight;

    Edge(Node l, double w) {
        linkTo = l;
        weight = w;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Node> nodes = new HashMap<>(equations.size());
        for (int i = 0; i < equations.size(); ++i) {
            List<String> eqn = equations.get(i);
            String fromNode = eqn.get(0), toNode = eqn.get(1);

            nodes.putIfAbsent(fromNode, new Node());
            nodes.putIfAbsent(toNode, new Node());

            nodes.get(fromNode).outLinks.add(new Edge(nodes.get(toNode), values[i]));
            nodes.get(toNode).outLinks.add(new Edge(nodes.get(fromNode), 1.0 / values[i]));
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            List<String> query = queries.get(i);
            Node fromNode = nodes.get(query.get(0));
            Node toNode = nodes.get(query.get(1));

            results[i] = -1.0;
            if (fromNode == null || toNode == null)
                continue;

            if (fromNode == toNode)
                results[i] = 1.0;
            else {
                Double collectedWeight = fromNode.dfsToFind(toNode, new HashSet<>());
                if (collectedWeight == null)
                    continue;
                results[i] = collectedWeight;
            }
        }

        return results;
    }
}
