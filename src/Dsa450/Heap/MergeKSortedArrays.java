package src.Dsa450.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

}

class Solution {
    static class ArrIdx {
        int idxAt;
        int[] inArr;

        ArrIdx(int a, int[] b) {
            idxAt = a;
            inArr = b;
        }

        Integer get() {
            return inArr[idxAt];
        }

        void next() {
            ++this.idxAt;
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] matrix, int k) {
        var indicesMinHeap = new PriorityQueue<ArrIdx>(k, (a, b) -> a.get().compareTo(b.get()));
        for (int i = 0; i < k; ++i)
            indicesMinHeap.offer(new ArrIdx(0, matrix[i]));

        ArrayList<Integer> result = new ArrayList<>(k * k);

        while (!indicesMinHeap.isEmpty()) {
            ArrIdx arrIdx = indicesMinHeap.poll();
            result.add(arrIdx.get());

            arrIdx.next();
            if (arrIdx.idxAt < k)
                indicesMinHeap.offer(arrIdx);
        }

        return result;
    }
}
