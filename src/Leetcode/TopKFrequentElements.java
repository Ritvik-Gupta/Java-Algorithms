package src.Leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

}

class Solution {
    class FreqElm {
        Integer num, freq;

        FreqElm(int n, int f) {
            num = n;
            freq = f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numFreqs = new HashMap<>();

        for (int num : nums)
            numFreqs.put(num, numFreqs.getOrDefault(num, 0) + 1);

        PriorityQueue<FreqElm> mostFreq = new PriorityQueue<>(k + 1, (a, b) -> a.freq.compareTo(b.freq));

        numFreqs.forEach((num, freq) -> {
            mostFreq.offer(new FreqElm(num, freq));

            if (mostFreq.size() > k)
                mostFreq.poll();
        });

        int[] result = new int[k];
        for (int i = 0; i < k; ++i)
            result[i] = mostFreq.poll().num;

        return result;
    }
}
