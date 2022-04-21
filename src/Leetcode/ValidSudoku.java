package src.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class ValidSudoku {

}

class Solution {
    static int GRID_SIZE = 9;
    static int SUBBOX_SIZE = 3;

    int coordToIdx(int row, int col) {
        return row * SUBBOX_SIZE + col;
    }

    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> subBoxesValidation = new ArrayList<>(GRID_SIZE);
        for (int i = 0; i < GRID_SIZE; ++i)
            subBoxesValidation.add(new HashSet<>(9));

        for (int row = 0; row < GRID_SIZE; ++row) {
            HashSet<Character> rowValidation = new HashSet<>(GRID_SIZE);
            HashSet<Character> colValidation = new HashSet<>(GRID_SIZE);
            for (int col = 0; col < GRID_SIZE; ++col) {
                if (board[row][col] != '.') {
                    if (!rowValidation.add(board[row][col]))
                        return false;

                    int subBoxIdx = coordToIdx(row / SUBBOX_SIZE, col / SUBBOX_SIZE);
                    if (!subBoxesValidation.get(subBoxIdx).add(board[row][col]))
                        return false;
                }

                if (board[col][row] != '.')
                    if (!colValidation.add(board[col][row]))
                        return false;
            }
        }

        return true;
    }
}
