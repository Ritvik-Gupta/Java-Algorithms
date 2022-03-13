package src.Leetcode.WeeklyContest284;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {

}

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> foundKeysAt = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i)
            if (nums[i] == key)
                foundKeysAt.add(i);

        ArrayList<Integer> result = new ArrayList<>();
        int prevIdx = -1;
        for (int i = 0; i < foundKeysAt.size(); ++i) {
            int idx = foundKeysAt.get(i) - k;
            if (idx <= prevIdx)
                idx = prevIdx + 1;

            while (idx < nums.length && Math.abs(foundKeysAt.get(i) - idx) <= k) {
                result.add(idx);
                ++idx;
            }
            prevIdx = idx-1;
        }

        return result;
    }
}
