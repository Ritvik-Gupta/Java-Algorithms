package src.Leetcode.BiweeklyContest75;

public class FindTriangularSumOfAnArray {

}

class Solution {
    public int triangularSum(int[] nums) {
        int len = nums.length;

        for (int i = len - 1; i >= 1; --i) {
            for (int j = 0; j < i; ++j)
                nums[j] = (nums[j] + nums[j + 1]) % 10;
        }
        return nums[0];
    }
}
