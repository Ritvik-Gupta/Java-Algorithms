package src.Leetcode;

public class NumberOfIslands {
}

class Solution {
    private static final Vector[] NEIGHBOR_OFFSETS = {
            new Vector(-1, 0),
            new Vector(1, 0),
            new Vector(0, -1),
            new Vector(0, 1)
    };

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        int totalIslands = 0;
        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < m; y++) {
                Vector pos = new Vector(x, y);

                if (pos.locateIn(grid) == '1') {
                    exploreIsland(grid, pos);
                    totalIslands++;
                }
            }
        }
        return totalIslands;
    }

    private static class Vector {
        int x, y;

        Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Vector add(Vector offset) {
            return new Vector(this.x + offset.x, this.y + offset.y);
        }

        char locateIn(char[][] grid) {
            if (this.x < 0 || this.x >= grid.length)
                return '0';
            if (this.y < 0 || this.y >= grid[0].length)
                return '0';

            return grid[this.x][this.y];
        }

        void updateIn(char[][] grid, char mapFeature) {
            grid[this.x][this.y] = mapFeature;
        }
    }

    private void exploreIsland(char[][] grid, Vector pos) {
        pos.updateIn(grid, '0');

        for (Vector offset : NEIGHBOR_OFFSETS) {
            Vector neighborPos = pos.add(offset);
            if (neighborPos.locateIn(grid) == '1')
                exploreIsland(grid, neighborPos);
        }
    }
}
