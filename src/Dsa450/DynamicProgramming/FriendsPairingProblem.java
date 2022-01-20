package src.Dsa450.DynamicProgramming;

public class FriendsPairingProblem {
}

class Solution {
    private static final long BIG_MODULO = 1000000007;

    private static long[][] computeCombinationTable(int N, int R) {
        long[][] table = new long[N + 1][R + 1];
        for (int i = 0; i <= R; ++i)
            table[0][i] = 0;
        for (int i = 0; i <= N; ++i)
            table[i][0] = 1;

        for (int n = 1; n <= N; ++n)
            for (int r = 1; r <= R; ++r)
                table[n][r] = (table[n - 1][r] + table[n - 1][r - 1]) % BIG_MODULO;

        return table;
    }

    public long countFriendsPairings(int n) {
        long[][] combinationTable = computeCombinationTable(n, 2);

        long result = 1, numerator = 1;
        for (int i = 0; i < n / 2; ++i) {
            numerator *= combinationTable[n - i * 2][2];
            numerator /= (i + 1);
            numerator %= BIG_MODULO;
            result += numerator;
        }
        return result;
    }
}
