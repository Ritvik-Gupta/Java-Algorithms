package src.Leetcode;

public class BrokenCalculator {

}

class Solution {
    public int brokenCalc(int startValue, int target) {
        int totalOperations = 0;
        while (target > startValue) {
            if (target % 2 == 0)
                target /= 2;
            else
                target += 1;

            ++totalOperations;
        }
        return totalOperations + startValue - target;
    }
}
