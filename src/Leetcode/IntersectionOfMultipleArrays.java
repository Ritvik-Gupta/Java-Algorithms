package src.Leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionOfMultipleArrays {

}

class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashSet<Integer> intersectionSet = new HashSet<>(nums[0].length);

        for (int num : nums[0])
            intersectionSet.add(num);

        for (int i = 1; i < nums.length; ++i) {
            HashSet<Integer> nextSet = new HashSet<>(nums[0].length);
            for (int num : nums[i])
                if (intersectionSet.contains(num))
                    nextSet.add(num);

            intersectionSet = nextSet;
        }

        return intersectionSet.stream().sorted().collect(Collectors.toList());
    }
}
