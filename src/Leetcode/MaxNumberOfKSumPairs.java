package src.Leetcode;

import java.util.HashMap;

public class MaxNumberOfKSumPairs {

}

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> requiredNumsRecord = new HashMap<>(nums.length / 2);
        int numPairs = 0;

        for (int i = 0; i < nums.length; ++i) {
            Integer prevNumsFreq = requiredNumsRecord.get(nums[i]);
            if (prevNumsFreq != null) {
                ++numPairs;

                if (prevNumsFreq == 1)
                    requiredNumsRecord.remove(nums[i]);
                else
                    requiredNumsRecord.put(nums[i], prevNumsFreq - 1);
            } else {
                int otherNum = k - nums[i];
                requiredNumsRecord.put(otherNum, requiredNumsRecord.getOrDefault(otherNum, 0) + 1);
            }
        }

        return numPairs;
    }
}
