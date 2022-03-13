package src.Leetcode.WeeklyContest284;

public class MaximizeTheTopmostElementAfterKMoves {

}

class Solution {
    public int maximumTop(int[] nums, int k) {
        int totalNums = nums.length;

        if (totalNums == 1)
            return k % 2 == 0 ? nums[0] : -1;

        int maxNum = Integer.MIN_VALUE;

        if (totalNums < k) {
            for (int i = 0; i < totalNums; ++i)
                maxNum = Math.max(maxNum, nums[i]);
        } else if (totalNums == k) {
            for (int i = 0; i < totalNums - 1; ++i)
                maxNum = Math.max(maxNum, nums[i]);
        } else {
            for (int i = 0; i < k - 1; ++i)
                maxNum = Math.max(maxNum, nums[i]);

            if (maxNum <= nums[k])
                maxNum = nums[k];
        }
        return maxNum;
    }
}
