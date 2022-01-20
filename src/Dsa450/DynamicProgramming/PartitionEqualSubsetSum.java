package src.Dsa450.DynamicProgramming;

public class PartitionEqualSubsetSum {
}

class Solution {
    static int equalPartition(int __, int arr[]) {
        int arraySum = 0;
        for (int i = 0; i < arr.length; ++i)
            arraySum += arr[i];

        if (arraySum % 2 == 1)
            return 0;

        int sumRequired = arraySum / 2;

        boolean[][] table = new boolean[arr.length + 1][sumRequired + 1];
        for (int i = 0; i <= arr.length; ++i)
            table[i][0] = true;
        for (int i = 0; i <= sumRequired; ++i)
            table[0][i] = false;

        for (int idx = 1; idx <= arr.length; ++idx)
            for (int sum = 1; sum <= sumRequired; ++sum) {
                table[idx][sum] = table[idx - 1][sum];
                if (arr[idx - 1] <= sum)
                    table[idx][sum] = table[idx][sum] || table[idx - 1][sum - arr[idx - 1]];
            }

        return table[arr.length][sumRequired] ? 1 : 0;
    }
}
