package src.Gfg;

public class MaximumPathSumInMatrix {

}

class Solution {
    static int maximumPath(int size, int matrix[][]) {
        for (int i = 1; i < size; ++i)
            for (int j = 0; j < size; ++j) {
                int pathSumAbove = matrix[i - 1][j];
                if (j > 0)
                    pathSumAbove = Math.max(pathSumAbove, matrix[i - 1][j - 1]);
                if (j < size - 1)
                    pathSumAbove = Math.max(pathSumAbove, matrix[i - 1][j + 1]);

                matrix[i][j] += pathSumAbove;
            }

        int maxPathSum = 0;
        for (int i = 0; i < size; ++i)
            maxPathSum = Math.max(maxPathSum, matrix[size - 1][i]);
        return maxPathSum;
    }
}
