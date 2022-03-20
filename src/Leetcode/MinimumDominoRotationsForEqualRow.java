package src.Leetcode;

public class MinimumDominoRotationsForEqualRow {

}

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minMoves = Integer.MAX_VALUE;
        for (int tile = 1; tile <= 6; ++tile)
            minMoves = Math.min(minMoves, checkForTile(tile, tops, bottoms));

        return minMoves == Integer.MAX_VALUE ? -1 : minMoves;
    }

    private int checkForTile(int tile, int[] tops, int[] bottoms) {
        int len = tops.length;

        int topCount = 0, bottomCount = 0;
        for (int i = 0; i < len; ++i) {
            if (tops[i] != tile && bottoms[i] != tile)
                return Integer.MAX_VALUE;

            if (tops[i] == tile)
                topCount++;
            if (bottoms[i] == tile)
                bottomCount++;
        }

        return len - Math.max(topCount, bottomCount);
    }
}
