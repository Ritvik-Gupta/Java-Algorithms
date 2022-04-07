package src.Leetcode;

import java.util.PriorityQueue;

public class LastStoneWeight {

}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> boulders = new PriorityQueue<>(stones.length, (a, b) -> b.compareTo(a));

        for (int stone : stones)
            boulders.offer(stone);

        while (!boulders.isEmpty()) {
            int bigBoulder = boulders.poll();
            if (boulders.isEmpty())
                return bigBoulder;

            int smallBoulder = boulders.poll();

            if (bigBoulder != smallBoulder)
                boulders.offer(bigBoulder - smallBoulder);
        }

        return 0;
    }
}
