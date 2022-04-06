package src.Leetcode;

import java.util.HashMap;

public class ThreeSumWithMultiplicity {
}

class Solution {
    static int MODULO = (int) 1e9 + 7;

    public int threeSumMulti(int[] arr, int target) {
        HashMap<Integer, Integer> prevSeenKNums = new HashMap<>();

        int total = 0;
        for (int i = 0; i < arr.length; ++i) {
            total = (total + prevSeenKNums.getOrDefault(target - arr[i], 0)) % MODULO;
            for (int j = 0; j < i; ++j) {
                int requiredArrK = arr[i] + arr[j];
                prevSeenKNums.put(requiredArrK, prevSeenKNums.getOrDefault(requiredArrK, 0) + 1);
            }
        }

        return total;
    }
}
