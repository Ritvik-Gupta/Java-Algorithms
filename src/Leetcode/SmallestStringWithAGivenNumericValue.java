package src.Leetcode;

public class SmallestStringWithAGivenNumericValue {

}

class Solution {
    public String getSmallestString(int n, int k) {
        char[] smallestCombination = new char[n];
        recur(smallestCombination, n - 1, k);
        return String.valueOf(smallestCombination);
    }

    private boolean recur(char[] smallestCombination, int index, int k) {
        for (int chosenChar = Math.min(26, k); chosenChar > 0; --chosenChar) {
            smallestCombination[index] = (char) (chosenChar - 1 + 'a');
            if (index == 0 && k == chosenChar)
                return true;

            if (recur(smallestCombination, index - 1, k - chosenChar))
                return true;
        }
        return false;
    }
}
