package src.Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {

}

class Solution {
    static class TripLocation {
        Integer passengers, from, to;

        TripLocation(int[] trip) {
            passengers = trip[0];
            from = trip[1];
            to = trip[2];
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> {
            Integer fromA = a[1], fromB = b[1];
            return fromA.compareTo(fromB);
        });

        int passengersInCar = 0;
        PriorityQueue<TripLocation> tripsLeft = new PriorityQueue<>((a, b) -> a.to.compareTo(b.to));

        for (int i = 0; i < trips.length; ++i) {
            TripLocation trip = new TripLocation(trips[i]);

            while (!tripsLeft.isEmpty() && tripsLeft.peek().to <= trip.from)
                passengersInCar -= tripsLeft.poll().passengers;

            tripsLeft.offer(trip);
            passengersInCar += trip.passengers;

            if (passengersInCar > capacity)
                return false;
        }

        return true;
    }
}
