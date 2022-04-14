package src.Dsa450.Heap;

import java.util.PriorityQueue;

public class KLargestElements {
}

class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> kLargestElms = new PriorityQueue<>(k + 1);

        for (int i = 0; i < n; ++i) {
            kLargestElms.offer(arr[i]);

            if (kLargestElms.size() > k)
                kLargestElms.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; --i)
            result[i] = kLargestElms.poll();
        return result;
    }
}
