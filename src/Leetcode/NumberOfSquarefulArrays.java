package src.Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class NumberOfSquarefulArrays {
}

class Solution {
    private static class SquarefulElm {
        int frequency = 1;
        HashSet<Integer> links = new HashSet<>();
    }

    private boolean isSquareful(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    private int dfsToFindHamiltonianPaths(
            HashMap<Integer, SquarefulElm> squareElmRecord,
            int elm,
            int numNodesToTraverse) {
        if (numNodesToTraverse == 0)
            return 1;

        int totalPaths = 0;
        for (int linkedElm : squareElmRecord.get(elm).links) {
            if (squareElmRecord.get(linkedElm).frequency != 0) {
                squareElmRecord.get(linkedElm).frequency--;
                totalPaths += dfsToFindHamiltonianPaths(squareElmRecord, linkedElm, numNodesToTraverse - 1);
                squareElmRecord.get(linkedElm).frequency++;
            }
        }
        return totalPaths;
    }

    public int numSquarefulPerms(int[] nums) {
        HashMap<Integer, SquarefulElm> squareElmRecord = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            SquarefulElm record = squareElmRecord.get(nums[i]);
            if (record != null)
                record.frequency++;
            else
                squareElmRecord.put(nums[i], new SquarefulElm());
        }

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (isSquareful(nums[i] + nums[j])) {
                    squareElmRecord.get(nums[i]).links.add(nums[j]);
                    squareElmRecord.get(nums[j]).links.add(nums[i]);
                }
            }
        }

        int totalPaths = 0;
        for (int key : squareElmRecord.keySet()) {
            squareElmRecord.get(key).frequency--;
            totalPaths += dfsToFindHamiltonianPaths(squareElmRecord, key, nums.length - 1);
            squareElmRecord.get(key).frequency++;
        }
        return totalPaths;
    }
}
