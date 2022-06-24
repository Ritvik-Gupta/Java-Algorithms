package src.Gfg;

public class LongestConsecutive1s {

}

class Solution {
    public static int maxConsecutiveOnes(int num) {
        int maxOnes = 0;
        int consecutiveOnes = 0;
        while (num != 0) {
            if ((num & 1) != 0)
                consecutiveOnes += 1;
            else {
                maxOnes = Math.max(maxOnes, consecutiveOnes);
                consecutiveOnes = 0;
            }
            num >>= 1;
        }

        return Math.max(maxOnes, consecutiveOnes);
    }
}
