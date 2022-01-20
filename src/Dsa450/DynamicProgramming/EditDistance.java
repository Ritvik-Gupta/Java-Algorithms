package src.Dsa450.DynamicProgramming;

public class EditDistance {
}

class Solution {
    public int editDistance(String startStr, String endStr) {
        int[][] table = new int[startStr.length() + 1][endStr.length() + 1];
        for (int i = 0; i <= startStr.length(); ++i)
            table[i][0] = i;
        for (int i = 0; i <= endStr.length(); ++i)
            table[0][i] = i;

        for (int n = 1; n <= startStr.length(); ++n)
            for (int m = 1; m <= endStr.length(); ++m) {
                if (startStr.charAt(n - 1) == endStr.charAt(m - 1))
                    table[n][m] = table[n - 1][m - 1];
                else
                    table[n][m] = 1 + Math.min(
                        table[n - 1][m - 1],
                        Math.min(table[n - 1][m], table[n][m - 1])
                    );
            }

        return table[startStr.length()][endStr.length()];
    }
}
