package src.Leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

}

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k + 1);

        for (int num : nums) {
            pq.add(num);
            if (pq.size() == k)
                pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() == k)
            pq.poll();
        return pq.peek();
    }
}
