package src.Dsa450.DynamicProgramming;

public class CoinChange {
}

class Solution {
    public long count(int arr[], int arrSize, int changeRequired) {
        long[][] table = new long[arrSize + 1][changeRequired + 1];
        for (int i = 0; i <= changeRequired; ++i)
            table[0][i] = 0;
        for (int i = 0; i <= arrSize; ++i)
            table[i][0] = 1;

        for (int idx = 1; idx <= arrSize; ++idx)
            for (int leftChange = 1; leftChange <= changeRequired; ++leftChange) {
                table[idx][leftChange] = table[idx - 1][leftChange];
                if (arr[idx - 1] <= leftChange)
                    table[idx][leftChange] += table[idx][leftChange - arr[idx - 1]];
            }

        return table[arrSize][changeRequired];
    }
}
