package src.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
}

class Solution {

    public List<Integer> partitionLabels(String s) {
        int[] endForChar = new int[26];

        for (int i = 0; i < s.length(); ++i)
            endForChar[s.charAt(i) - 'a'] = i;

        List<Integer> parititions = new ArrayList<>();
        int partitionStart = 0, partitionEnd = 0;
        for (int i = 0; i < s.length(); ++i) {
            partitionEnd = Math.max(partitionEnd, endForChar[s.charAt(i) - 'a']);

            if (partitionEnd == i) {
                parititions.add(partitionEnd - partitionStart + 1);
                partitionStart = partitionEnd + 1;
            }
        }

        return parititions;
    }
}
