package src.Leetcode;

public class CountingBits {

}

class Solution {
    public int[] countBits(int n) {
        int[] oneBitsList = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            int smallerMSB = smallerMostSignificantBitNumber(i);
            System.out.println(i + "\t" + smallerMSB);
            boolean hasMostSignificantBit = ((smallerMSB + 1) & i) != 0;
            oneBitsList[i] = oneBitsList[smallerMSB & i] + (hasMostSignificantBit ? 1 : 0);
        }

        return oneBitsList;
    }

    private int smallerMostSignificantBitNumber(int num) {
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;

        return num >> 1;
    }
}
