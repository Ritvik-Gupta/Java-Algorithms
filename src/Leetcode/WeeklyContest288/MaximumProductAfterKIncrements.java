package src.Leetcode.WeeklyContest288;

import java.util.PriorityQueue;

public class MaximumProductAfterKIncrements {

}

class Solution {
    static int MODULO = (int) (1e9 + 7);

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length);
        for (int num : nums)
            pq.offer(num);

        for (int i = 0; i < k; ++i)
            pq.offer(pq.poll() + 1);

        long res = 1;
        while (!pq.isEmpty())
            res = (res * pq.poll()) % MODULO;

        return (int) res;
    }
}
