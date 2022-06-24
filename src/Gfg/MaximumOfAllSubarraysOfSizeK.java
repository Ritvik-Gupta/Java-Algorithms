package src.Gfg;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaximumOfAllSubarraysOfSizeK {
}

class SlidingWindow {
    int[] nums;
    int windowSize;
    ArrayDeque<Integer> window;

    SlidingWindow(int[] n, int ws) {
        nums = n;
        windowSize = ws;
        window = new ArrayDeque<>(windowSize + 1);
    }

    boolean hasExtendedWindow(int idx) {
        Integer frontIdx = window.peekFirst();
        if (frontIdx == null)
            return false;
        return frontIdx + windowSize <= idx;
    }

    boolean hasUnwantedIndices(int elm) {
        Integer backIdx = window.peekLast();
        if (backIdx == null)
            return false;
        return nums[backIdx] < elm;
    }
}

class Solution {
    static ArrayList<Integer> max_of_subarrays(int nums[], int n, int k) {
        SlidingWindow maxSliding = new SlidingWindow(nums, k);
        ArrayList<Integer> result = new ArrayList<>(nums.length - maxSliding.windowSize + 1);

        for (int idx = 0; idx < nums.length; ++idx) {
            if (maxSliding.hasExtendedWindow(idx))
                maxSliding.window.removeFirst();

            while (maxSliding.hasUnwantedIndices(nums[idx]))
                maxSliding.window.removeLast();

            maxSliding.window.addLast(idx);
            if (idx + 1 >= maxSliding.windowSize)
                result.add(nums[maxSliding.window.getFirst()]);
        }

        return result;
    }
}
