package src.Leetcode;

public class SpiralMatrix2 {
}

enum Direction {
    LEFT, DOWN, RIGHT, UP;

    public Direction next() {
        switch (this) {
            case LEFT:
                return DOWN;
            case DOWN:
                return RIGHT;
            case RIGHT:
                return UP;
            case UP:
                return LEFT;
        }
        throw new Error();
    }
}

class Position {
    int x, y;

    Position() {
        x = 0;
        y = 0;
    }

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position next(Direction dir) {
        switch (dir) {
            case LEFT:
                return new Position(x, y + 1);
            case DOWN:
                return new Position(x + 1, y);
            case RIGHT:
                return new Position(x, y - 1);
            case UP:
                return new Position(x - 1, y);
        }
        throw new Error();
    }

    int getIn(int[][] matrix) {
        return matrix[x][y];
    }

    void setIn(int[][] matrix, int value) {
        matrix[x][y] = value;
    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int boardSize = n * n, totalFilled = 1;
        Position pos = new Position();
        Direction dir = Direction.LEFT;

        while (totalFilled <= boardSize) {
            pos.setIn(matrix, totalFilled);
            ++totalFilled;

            Position nextPos = pos.next(dir);
            if (nextPos.x < 0 || nextPos.x >= n || nextPos.y < 0 || nextPos.y >= n || nextPos.getIn(matrix) != 0) {
                dir = dir.next();
                nextPos = pos.next(dir);
            }
            pos = nextPos;
        }

        return matrix;
    }
}
