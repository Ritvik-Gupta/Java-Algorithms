package src.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

}

class Solution {
    private void findValidCombinations(
        List<List<Integer>> allCombinations, 
        ArrayList<Integer> combination, 
        int startNum, 
        int left,
        int k
    ) {
        if (left == 0 && combination.size() == k) {
            allCombinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startNum; i < 10; ++i) {
            if(left < i) break;
            combination.add(i);
            findValidCombinations(allCombinations, combination, i + 1, left - i, k);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        findValidCombinations(allCombinations, new ArrayList<>(), 1, n, k);
        return allCombinations;
    }
}
