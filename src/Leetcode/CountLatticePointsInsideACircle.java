package src.Leetcode;

import java.util.TreeSet;

public class CountLatticePointsInsideACircle {

}

class Point implements Comparable<Point> {
    Integer x, y;

    Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public int compareTo(Point other) {
        int comp = this.x.compareTo(other.x);
        if (comp != 0)
            return comp;
        return this.y.compareTo(other.y);
    }

    double squaredDistanceTo(Point point) {
        return Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2);
    }
}

class Solution {
    public int countLatticePoints(int[][] circles) {
        TreeSet<Point> latticePoints = new TreeSet<>();

        for (int[] circle : circles) {
            Point circlePoint = new Point(circle[0], circle[1]);
            int radius = circle[2];
            int sqauredRadius = radius * radius;

            for (int x = circlePoint.x - radius; x <= circlePoint.x + radius; ++x)
                for (int y = circlePoint.y - radius; y <= circlePoint.y + radius; ++y) {
                    Point point = new Point(x, y);
                    if (circlePoint.squaredDistanceTo(point) <= sqauredRadius)
                        latticePoints.add(point);
                }
        }

        return latticePoints.size();
    }
}
