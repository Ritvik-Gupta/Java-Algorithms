package src.Leetcode;

import java.util.Arrays;

public class TwoCityScheduling {

}

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (cost1, cost2) -> {
            int costDiff1 = cost1[0] - cost1[1], costDiff2 = cost2[0] - cost2[1];
            if (costDiff1 > costDiff2)
                return 1;
            if (costDiff1 < costDiff2)
                return -1;
            return 0;
        });

        int n = costs.length / 2, totalCost = 0;
        for (int i = 0; i < n; ++i)
            totalCost += costs[i][0] + costs[n + i][1];

        return totalCost;
    }
}
