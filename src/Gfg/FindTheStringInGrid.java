package src.Gfg;

import java.util.ArrayList;

public class FindTheStringInGrid {

}

class Coord {
    int x, y;

    Coord(int a, int b) {
        x = a;
        y = b;
    }

    int[] into() {
        return new int[] { x, y };
    }

    void add(Coord other) {
        x += other.x;
        y += other.y;
    }

    Coord copy() {
        return new Coord(x, y);
    }
}

class Solution {
    boolean directionContainsWord(char[][] grid, String word, Coord coor, Coord directionDelta) {
        for (int i = 1; i < word.length(); ++i) {
            coor.add(directionDelta);
            if (coor.x < 0 || coor.x >= grid.length || coor.y < 0 || coor.y >= grid[0].length)
                return false;
            if (grid[coor.x][coor.y] != word.charAt(i))
                return false;
        }
        return true;
    }

    boolean hasAnyDirectional(char[][] grid, String word, Coord coor) {
        for (int i = -1; i <= 1; ++i)
            for (int j = -1; j <= 1; ++j)
                if (i == 0 && j == 0)
                    continue;
                else if (directionContainsWord(grid, word, coor.copy(), new Coord(i, j)))
                    return true;
        return false;
    }

    public int[][] searchWord(char[][] grid, String word) {
        ArrayList<Coord> result = new ArrayList<>();
        for (int x = 0; x < grid.length; ++x)
            for (int y = 0; y < grid[0].length; ++y)
                if (grid[x][y] == word.charAt(0) && hasAnyDirectional(grid, word, new Coord(x, y)))
                    result.add(new Coord(x, y));

        int[][] res = new int[result.size()][];
        for (int i = 0; i < result.size(); ++i)
            res[i] = result.get(i).into();
        return res;
    }
}
