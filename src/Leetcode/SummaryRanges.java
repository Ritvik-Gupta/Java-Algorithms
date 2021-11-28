package src.Leetcode;

import java.util.NoSuchElementException;
import java.util.TreeSet;

public class SummaryRanges {
    private TreeSet<RangeSummary> ranges;

    public SummaryRanges() {
        this.ranges = new TreeSet<>();
    }

    public void addNum(int val) {
        int lowerBound = val, upperBound = val;

        if (!this.ranges.contains(new RangeSummary(lowerBound, upperBound))) {
            var lowerRange = this.ranges.lower(new RangeSummary(lowerBound, upperBound));
            if (lowerRange != null && lowerRange.contains(lowerBound - 1)) {
                this.ranges.remove(lowerRange);
                lowerBound = lowerRange.start;
            }
            var upperRange = this.ranges.higher(new RangeSummary(lowerBound, upperBound));
            if (upperRange != null && upperRange.contains(upperBound + 1)) {
                this.ranges.remove(upperRange);
                upperBound = upperRange.end;
            }
            this.ranges.add(new RangeSummary(lowerBound, upperBound));
        }
    }

    public int[][] getIntervals() {
        var result = new int[this.ranges.size()][2];
        int i = 0;
        for (var range : ranges) {
            result[i] = range.collect();
            ++i;
        }
        return result;
    }
}

class RangeSummary implements Comparable<RangeSummary> {
    public final int start, end;

    RangeSummary(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int[] collect() {
        return new int[] { this.start, this.end };
    }

    boolean contains(int val) {
        return this.start <= val && val <= this.end;
    }

    @Override
    public int compareTo(RangeSummary other) {
        if (other.contains(this.start) || other.contains(this.end))
            return 0;
        else if (this.start > other.end)
            return 1;
        else if (other.start > this.end)
            return -1;
        else
            throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        return "[" + this.start + ", " + this.end + "]";
    }
}
