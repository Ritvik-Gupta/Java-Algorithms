package src.Dsa450.BackTracking;

import java.util.ArrayList;

public class RatInAMazeProblem1 {

}

class Solution {
    public static ArrayList<String> findPath(int[][] maze, int n) {
        ArrayList<String> paths = new ArrayList<>();
        dfsMaze(maze, paths, 0, 0, "");
        return paths;
    }

    private static void dfsMaze(int[][] maze, ArrayList<String> paths, int row, int col, String path) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze.length)
            return;
        if (maze[row][col] == 0)
            return;

        if (row == maze.length - 1 && col == maze.length - 1) {
            paths.add(path);
            return;
        }

        maze[row][col] = 0;
        dfsMaze(maze, paths, row + 1, col, path + "D");
        dfsMaze(maze, paths, row, col - 1, path + "L");
        dfsMaze(maze, paths, row, col + 1, path + "R");
        dfsMaze(maze, paths, row - 1, col, path + "U");
        maze[row][col] = 1;
    }
}
