package src.Leetcode;

public class NextPermutation {
}

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            --i;

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                --j;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int startIdx) {
        for (int left = startIdx, right = nums.length - 1; left < right; ++left, --right)
            swap(nums, left, right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
