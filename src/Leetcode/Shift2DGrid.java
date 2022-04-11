package src.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

}

class Solution {
    static int MAX_K_SHIFTS = 101;

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        Grid dataGrid = new Grid(grid);
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < dataGrid.dimension.row; ++row) {
            List<Integer> rowData = new ArrayList<>();
            for (int col = 0; col < dataGrid.dimension.col; ++col)
                rowData.add(
                    dataGrid.get(
                        dataGrid.indexCoor((dataGrid.size() * MAX_K_SHIFTS +
                        dataGrid.coorIndex(new Coordinate(row, col)) - k))
                    )
                );
            result.add(rowData);
        }

        return result;
    }
}

class Coordinate {
    int row, col;

    Coordinate(int r, int c) {
        row = r;
        col = c;
    }
}

class Grid {
    int[][] data;
    Coordinate dimension;

    Grid(int[][] d) {
        data = d;
        dimension = new Coordinate(data.length, data[0].length);
    }

    int size() {
        return dimension.row * dimension.col;
    }

    int get(Coordinate coor) {
        return data[coor.row][coor.col];
    }

    int coorIndex(Coordinate coor) {
        return coor.row * dimension.col + coor.col;
    }

    Coordinate indexCoor(int index) {
        index = index % size();
        return new Coordinate(index / dimension.col, index % dimension.col);
    }
}
