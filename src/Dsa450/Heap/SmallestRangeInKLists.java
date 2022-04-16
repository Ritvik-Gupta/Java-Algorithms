package src.Dsa450.Heap;

import java.util.PriorityQueue;

public class SmallestRangeInKLists {

}

class Solution {
    static class ArrIdx {
        int[] inArr;
        int idxAt;

        ArrIdx(int[] arr) {
            inArr = arr;
            idxAt = 0;
        }

        boolean next() {
            ++idxAt;
            return idxAt < inArr.length;
        }

        Integer get() {
            return inArr[idxAt];
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

    static int[] findSmallestRange(int[][] sortedArrays, int n, int k) {
        int high = -1;
        Range minRange = new Range(-1, -1);
        var rangeHeap = new PriorityQueue<ArrIdx>(k, (a, b) -> a.get().compareTo(b.get()));

        for (int i = 0; i < k; ++i) {
            ArrIdx arrIdx = new ArrIdx(sortedArrays[i]);
            rangeHeap.offer(arrIdx);
            if (arrIdx.get() > minRange.high)
                minRange.high = arrIdx.get();
        }
        high = minRange.high;
        minRange.low = rangeHeap.peek().get();

        while (!rangeHeap.isEmpty()) {
            ArrIdx minArrIdx = rangeHeap.poll();

            if (minArrIdx.next()) {
                rangeHeap.offer(minArrIdx);

                if (rangeHeap.size() == k) {
                    if (minArrIdx.get() > high)
                        high = minArrIdx.get();

                    Range newRange = new Range(rangeHeap.peek().get(), high);

                    if (minRange.size() > newRange.size())
                        minRange = newRange;
                }
            }
        }

        return minRange.into();
    }
}
