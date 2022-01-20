package src.Dsa450.DynamicProgramming;

public class KnapsackProblem {

}

class Solution {
    static int knapSack(int finalWeight, int wt[], int val[], int numItems) {
        int[][] table = new int[numItems + 1][finalWeight + 1];
        for (int i = 0; i <= numItems; ++i)
            table[i][0] = 0;
        for (int i = 0; i <= finalWeight; ++i)
            table[0][i] = 0;

        for (int idx = 1; idx <= numItems; ++idx)
            for (int weight = 1; weight <= finalWeight; ++weight) {
                table[idx][weight] = table[idx - 1][weight];
                if (wt[idx - 1] <= weight)
                    table[idx][weight] = Math.max(
                        val[idx - 1] + table[idx - 1][weight - wt[idx - 1]],
                        table[idx][weight]
                    );
            }

        return table[numItems][finalWeight];
    }
}
