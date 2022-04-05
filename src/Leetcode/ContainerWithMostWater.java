package src.Leetcode;

public class ContainerWithMostWater {

}

class Solution {
    public int maxArea(int[] height) {
        int leftPtr = 0, rightPtr = height.length - 1;

        int maxContainerSize = 0;
        while (leftPtr < rightPtr) {
            maxContainerSize = Math.max(
                    maxContainerSize,
                    Math.min(height[leftPtr], height[rightPtr]) * (rightPtr - leftPtr));

            if (height[leftPtr] <= height[rightPtr])
                leftPtr++;
            else if (height[leftPtr] > height[rightPtr])
                rightPtr--;
        }

        return maxContainerSize;
    }
}
