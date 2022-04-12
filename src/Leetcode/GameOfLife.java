package src.Leetcode;

import java.util.function.BiConsumer;

public class GameOfLife {
}

class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;

        BiConsumer<Integer, Integer> updateCellState = (x, y) -> {
            int neighbors = 0;
            for (int i = -1; i <= 1; ++i)
                for (int j = -1; j <= 1; ++j)
                    if (x + i >= 0 && x + i < n && y + j >= 0 && y + j < m)
                        neighbors += board[x + i][y + j] % 10;

            if ((neighbors == 3) || (board[x][y] == 1 && neighbors == 4))
                board[x][y] += 10;
        };

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                updateCellState.accept(i, j);
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                board[i][j] /= 10;
            }
        }
    }
}
