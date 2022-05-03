package src.Leetcode;

import java.util.ArrayDeque;

public class ShortestUnsortedContinuousSubarray {
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        ArrayDeque<Integer> indexStack = new ArrayDeque<Integer>(nums.length / 2);
        int unsortedBegin = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            while (!indexStack.isEmpty() && nums[indexStack.peek()] > nums[i])
                unsortedBegin = Math.min(unsortedBegin, indexStack.pop());
            indexStack.push(i);
        }

        indexStack.clear();
        int unsortedEnd = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            while (!indexStack.isEmpty() && nums[indexStack.peek()] < nums[i])
                unsortedEnd = Math.max(unsortedEnd, indexStack.pop());
            indexStack.push(i);
        }

        int unsortedBoundary = unsortedEnd - unsortedBegin + 1;
        return unsortedBoundary > 1 ? unsortedBoundary : 0;
    }
}
