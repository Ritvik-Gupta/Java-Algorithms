package src.Dsa450.Heap;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
}

class Solution {
    long minCost(long arr[], int n) {
        long totalCost = 0;
        PriorityQueue<Long> ropeLengths = new PriorityQueue<>(arr.length);
        for (long rope : arr)
            ropeLengths.offer(rope);

        while (ropeLengths.size() != 1) {
            long newRopeLen = ropeLengths.poll() + ropeLengths.poll();
            totalCost += newRopeLen;
            ropeLengths.offer(newRopeLen);
        }

        return totalCost;
    }
}
