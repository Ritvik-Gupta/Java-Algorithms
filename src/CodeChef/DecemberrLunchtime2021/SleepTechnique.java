package src.CodeChef.DecemberrLunchtime2021;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SleepTechnique {
    private static final Scanner S = new Scanner(System.in);

    public static void main(String[] args) {
        for (int testCase = S.nextInt(); testCase-- > 0;)
            runTestCase();
    }

    private static void runTestCase() {
        int n = S.nextInt();

        long a = S.nextLong(), b = S.nextLong();
        long maxAllowedTime = (b - a) * (b + a + 1) / 2;

        PriorityQueue<TimeInterval> pq = new PriorityQueue<>((x, y) -> (int) (x.atTime - y.atTime));
        for (int i = 0; i < n; ++i) {
            pq.add(new TimeInterval(S.nextLong(), Interval.START));
            pq.add(new TimeInterval(S.nextLong(), Interval.END));
        }

        TimeInterval currInterval;
        int maxHeight = 0, height = 0;
        while ((currInterval = pq.poll()) != null) {
            if (currInterval.atTime > maxAllowedTime)
                break;
            height += currInterval.interval == Interval.START ? 1 : -1;
            if (maxHeight < height)
                maxHeight = height;
        }

        System.out.println(maxHeight);
    }

    static enum Interval {
        START, END;
    }

    static class TimeInterval {
        final long atTime;
        final Interval interval;

        TimeInterval(long atTime, Interval interval) {
            this.atTime = atTime;
            this.interval = interval;
        }
    }
}
