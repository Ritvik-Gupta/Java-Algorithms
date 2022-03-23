package src.Leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> nodeQueue = new ArrayDeque<>(rooms.size());
        HashSet<Integer> visitedNodes = new HashSet<>(rooms.size());

        nodeQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            int nodeIdx = nodeQueue.poll();
            if (visitedNodes.contains(nodeIdx))
                continue;

            visitedNodes.add(nodeIdx);
            for (int neighborNodeIdx : rooms.get(nodeIdx))
                nodeQueue.offer(neighborNodeIdx);
        }

        return visitedNodes.size() == rooms.size();
    }
}
