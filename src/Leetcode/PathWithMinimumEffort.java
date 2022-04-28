package src.Leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {

}

class GridVector implements Comparable<GridVector> {
    int x, y, effort;

    GridVector(int a, int b, int effort) {
        x = a;
        y = b;
        this.effort = effort;
    }

    @Override
    public int compareTo(GridVector other) {
        return Integer.compare(effort, other.effort);
    }
}

class Solution {
    static int[][] NEIGHBORING_OFFSETS = new int[][] {
                {-1, 0},
        {0, -1},        {0, +1},
                {+1, 0},
    };

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;

        Queue<GridVector> gridPosQueue = new PriorityQueue<>(n + m);
        ArrayList<ArrayList<Integer>> minDistComputed = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            minDistComputed.add(new ArrayList<>(m));
            for (int j = 0; j < m; ++j)
                minDistComputed.get(i).add(Integer.MAX_VALUE);
        }

        minDistComputed.get(0).set(0, 0);
        gridPosQueue.offer(new GridVector(0, 0, 0));

        while (!gridPosQueue.isEmpty()) {
            GridVector vec = gridPosQueue.poll();
            if (minDistComputed.get(vec.x).get(vec.y) < vec.effort)
                continue;
            if (vec.x == n - 1 && vec.y == m - 1)
                return vec.effort;

            for (int[] offset : NEIGHBORING_OFFSETS) {
                int dx = vec.x + offset[0];
                int dy = vec.y + offset[1];

                if (dx < 0 || dx >= n)
                    continue;
                if (dy < 0 || dy >= m)
                    continue;

                int minEffort = Math.max(vec.effort, Math.abs(heights[vec.x][vec.y] - heights[dx][dy]));
                if (minDistComputed.get(dx).get(dy) <= minEffort)
                    continue;
                minDistComputed.get(dx).set(dy, minEffort);
                gridPosQueue.offer(new GridVector(dx, dy, minEffort));
            }
        }
        return 0;
    }
}
