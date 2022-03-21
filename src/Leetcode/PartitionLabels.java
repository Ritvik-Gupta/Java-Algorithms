package src.Leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PartitionLabels {
}

class Solution {
    static class Range {
        int start, end;

        Range(int a, int b) {
            this.start = a;
            this.end = b;
        }

        static Range union(Range r1, Range r2) {
            return new Range(Math.min(r1.start, r2.start), Math.max(r1.end, r2.end));
        }

        @Override
        public Range clone() {
            return new Range(this.start, this.end);
        }

        @Override
        public String toString() {
            return "(" + this.start + ", " + this.end + ")";
        }
    }

    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Range> rangeOfChars = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            if (!rangeOfChars.containsKey(s.charAt(i)))
                rangeOfChars.put(s.charAt(i), new Range(i, i));
            else
                rangeOfChars.get(s.charAt(i)).end = i;
        }

        TreeMap<Range, Range> uniquePartitions = new TreeMap<>((a, b) -> {
            if (a.start <= b.start && b.start <= a.end)
                return 0;
            if (a.start <= b.end && b.end <= a.end)
                return 0;
            if (b.start <= a.start && a.start <= b.end)
                return 0;
            if (b.start <= a.end && a.end <= b.end)
                return 0;

            if (a.start > b.end)
                return 1;
            if (a.end < b.start)
                return -1;

            throw new Error("Range Err");
        });

        for (Range charRange : rangeOfChars.values()) {
            Range similarCharRange;
            while ((similarCharRange = uniquePartitions.remove(charRange)) != null)
                charRange = Range.union(charRange, similarCharRange);

            uniquePartitions.put(charRange.clone(), charRange.clone());
        }

        return uniquePartitions
                .values()
                .stream()
                .map(range -> range.end - range.start + 1)
                .collect(Collectors.toList());
    }
}
