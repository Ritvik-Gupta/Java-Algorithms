package src.Dsa450.DynamicProgramming;

public class NCR {

}

class Solution {
    private static final int BIG_MODULO = 1000000007;

    static int nCr(int N, int R) {
        int[][] table = new int[N + 1][R + 1];
        for (int i = 0; i <= R; ++i)
            table[0][i] = 0;
        for (int i = 0; i <= N; ++i)
            table[i][0] = 1;

        for (int n = 1; n <= N; ++n)
            for (int r = 1; r <= R; ++r)
                table[n][r] = (table[n - 1][r] + table[n - 1][r - 1]) % BIG_MODULO;

        return table[N][R];
    }
}
