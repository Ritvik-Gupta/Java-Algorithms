package src.Leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MaximumBuildingHeight {
}

class Solution {
    static class Building {
        Integer id, height;

        Building(int i, int h) {
            id = i;
            height = h;
        }
    }

    public int maxBuilding(int n, int[][] restrictions) {
        if (restrictions.length == 0)
            return n - 1;

        PriorityQueue<Building> buildingQueue = new PriorityQueue<>(restrictions.length,
                (a, b) -> a.height.compareTo(b.height));
        HashSet<Integer> visited = new HashSet<>(n);
        int[] heights = new int[n + 1];

        for (int[] restriction : restrictions) {
            int id = restriction[0];
            heights[id] = restriction[1];
            visited.add(id);
            buildingQueue.offer(new Building(id, heights[id]));
        }

        while (!buildingQueue.isEmpty()) {
            Building building = buildingQueue.poll();

            if (building.id - 1 >= 0) {
                if (visited.contains(building.id - 1)) {
                    if (heights[building.id] + 1 < heights[building.id - 1]) {
                        heights[building.id - 1] = heights[building.id] + 1;
                        buildingQueue.offer(new Building(building.id - 1, heights[building.id - 1]));
                    }
                } else {
                    heights[building.id - 1] = heights[building.id] + 1;
                    visited.add(building.id - 1);
                    buildingQueue.offer(new Building(building.id - 1, heights[building.id - 1]));
                }
            }

            if (building.id + 1 < heights.length) {
                if (visited.contains(building.id + 1)) {
                    if (heights[building.id] + 1 < heights[building.id + 1]) {
                        heights[building.id + 1] = heights[building.id] + 1;
                        buildingQueue.offer(new Building(building.id + 1, heights[building.id + 1]));
                    }
                } else {
                    heights[building.id + 1] = heights[building.id] + 1;
                    visited.add(building.id + 1);
                    buildingQueue.offer(new Building(building.id + 1, heights[building.id + 1]));
                }
            }
        }

        int maxHeightBuildingId = 1;
        heights[1] = 0;
        for (int id = 2; id < heights.length; ++id) {
            heights[id] = Math.min(heights[id - 1] + 1, heights[id]);
            if (heights[id] > heights[maxHeightBuildingId])
                maxHeightBuildingId = id;
        }

        return heights[maxHeightBuildingId];
    }
}
