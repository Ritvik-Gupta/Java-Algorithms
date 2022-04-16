package src.Leetcode;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {

}

class Solution {
    static class ArrIdx {
        List<Integer> inArr;
        int idxAt;

        ArrIdx(List<Integer> arr) {
            inArr = arr;
            idxAt = 0;
        }

        boolean next() {
            ++idxAt;
            return idxAt < inArr.size();
        }

        Integer get() {
            return inArr.get(idxAt);
        }
    }

    static class Range {
        int low, high;

        Range(int a, int b) {
            low = a;
            high = b;
        }

        int size() {
            return high - low;
        }

        int[] into() {
            return new int[] { low, high };
        }
    }

    public int[] smallestRange(List<List<Integer>> sortedArrays) {
        int k = sortedArrays.size();

        int rangeHigh = -1;
        var indexHeap = new PriorityQueue<ArrIdx>(k, (a, b) -> a.get().compareTo(b.get()));

        for (int i = 0; i < k; ++i) {
            ArrIdx arrIdx = new ArrIdx(sortedArrays.get(i));
            indexHeap.offer(arrIdx);
            rangeHigh = Math.max(rangeHigh, arrIdx.get());
        }
        Range minRange = new Range(indexHeap.peek().get(), rangeHigh);

        while (!indexHeap.isEmpty()) {
            ArrIdx minArrIdx = indexHeap.poll();

            if (!minArrIdx.next())
                continue;

            indexHeap.offer(minArrIdx);
            if (indexHeap.size() != k)
                continue;

            rangeHigh = Math.max(rangeHigh, minArrIdx.get());
            Range newRange = new Range(indexHeap.peek().get(), rangeHigh);
            if (minRange.size() > newRange.size())
                minRange = newRange;
        }

        return minRange.into();
    }
}
