package src.Leetcode.WeeklyContest288;

import java.util.ArrayList;

public class LargestNumberAfterDigitSwapsByParity {

}

class Solution {
    public int largestInteger(int num) {
        ArrayList<Integer> odds = new ArrayList<>(), evens = new ArrayList<>();
        ArrayList<Boolean> forOddDigits = new ArrayList<>();

        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            if (digit % 2 == 0)
                evens.add(digit);
            else
                odds.add(digit);

            forOddDigits.add(digit % 2 != 0);
        }

        odds.sort((a, b) -> b.compareTo(a));
        evens.sort((a, b) -> b.compareTo(a));

        int oddIdx = 0, evenIdx = 0;
        int res = 0;
        for (int i = forOddDigits.size() - 1; i >= 0; --i) {
            res *= 10;
            if (forOddDigits.get(i))
                res += odds.get(oddIdx++);
            else
                res += evens.get(evenIdx++);
        }

        return res;
    }
}
