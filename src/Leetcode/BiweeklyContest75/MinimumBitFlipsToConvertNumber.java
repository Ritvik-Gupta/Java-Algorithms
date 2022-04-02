package src.Leetcode.BiweeklyContest75;

public class MinimumBitFlipsToConvertNumber {

}

class Solution {
    public int minBitFlips(int start, int goal) {
        int minFlips = 0;
        int xorNum = start ^ goal;
        for (int i = 0; i < 32; ++i)
            if (hasBit(xorNum, i))
                ++minFlips;

        return minFlips;
    }

    private boolean hasBit(int num, int bitPos) {
        return (num & (1 << bitPos)) != 0;
    }
}
