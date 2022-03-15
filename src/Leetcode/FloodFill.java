package src.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

}

class Solution {
    private Vec2D[] NEIGHBOR_OFFSETS = {
            new Vec2D(-1, 0),
            new Vec2D(1, 0),
            new Vec2D(0, -1),
            new Vec2D(0, 1)
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Vec2D> queue = new LinkedList<>();
        queue.offer(new Vec2D(sr, sc));

        while (!queue.isEmpty()) {
            Vec2D pos = queue.poll();

            for (Vec2D offset : NEIGHBOR_OFFSETS) {
                Vec2D neighborPos = pos.add(offset);
                Integer neighborColor = neighborPos.locateIn(image);
                if (pos.locateIn(image) == neighborColor && neighborColor != newColor)
                    queue.offer(neighborPos);
            }

            pos.updateIn(image, newColor);
        }

        return image;
    }

    private static class Vec2D {
        int x, y;

        Vec2D(int x, int y) {
            this.x = x;
            this.y = y;

        }

        Vec2D add(Vec2D offset) {
            return new Vec2D(this.x + offset.x, this.y + offset.y);
        }

        Integer locateIn(int[][] grid) {
            if (this.x < 0 || this.x >= grid.length)
                return null;
            if (this.y < 0 || this.y >= grid[0].length)
                return null;

            return grid[this.x][this.y];
        }

        void updateIn(int[][] grid, int newColor) {
            grid[this.x][this.y] = newColor;
        }
    }
}
