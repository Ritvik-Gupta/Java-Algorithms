package src.Leetcode;

public class CountSortedVowelStrings {
}

class Solution {
    public int countVowelStrings(int n) {
        int[] vowelCombinations = new int[5];
        for (int i = 0; i < 5; ++i)
            vowelCombinations[i] = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < 5; ++j)
                vowelCombinations[j] += vowelCombinations[j - 1];
        }
        int total = 0;
        for (int i = 0; i < 5; ++i)
            total += vowelCombinations[i];
        return total;
    }
}
