package src.Leetcode;

import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {
}

class Solution {
    class RowStrength {
        Integer index, numSoldiers;

        RowStrength(int a, int b) {
            this.index = a;
            this.numSoldiers = b;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;

        PriorityQueue<RowStrength> pq = new PriorityQueue<>(k + 1, (a, b) -> {
            int comparingNumSoldiers = b.numSoldiers.compareTo(a.numSoldiers);
            return comparingNumSoldiers != 0 ? comparingNumSoldiers : b.index.compareTo(a.index);
        });

        for (int rowIndex = 0; rowIndex < n; ++rowIndex) {
            int numSoldiers = 0;
            for (int j = 0; j < m; ++j) {
                numSoldiers += mat[rowIndex][j];
                if (mat[rowIndex][j] == 0)
                    break;
            }
            pq.offer(new RowStrength(rowIndex, numSoldiers));
            if (pq.size() > k)
                pq.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; --i)
            result[i] = pq.poll().index;

        return result;
    }
}
