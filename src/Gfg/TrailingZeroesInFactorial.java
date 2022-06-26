package src.Gfg;

public class TrailingZeroesInFactorial {

}

class Solution {
    static int trailingZeroes(int num) {
        int result = 0;
        int fivePower = 5;
        while (fivePower <= num) {
            result += num / fivePower;
            fivePower *= 5;
        }
        return result;
    }
}
