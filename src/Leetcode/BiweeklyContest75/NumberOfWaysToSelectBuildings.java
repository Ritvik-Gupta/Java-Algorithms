package src.Leetcode.BiweeklyContest75;

public class NumberOfWaysToSelectBuildings {

}

class Solution {
    public long numberOfWays(String s) {
        long num0 = 0, num1 = 0, num01 = 0, num10 = 0, num010 = 0, num101 = 0;

        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                ++num0;
                num01 += num1;
                num010 += num10;
            } else {
                ++num1;
                num10 += num0;
                num101 += num01;
            }
        }
        return num010 + num101;
    }
}
