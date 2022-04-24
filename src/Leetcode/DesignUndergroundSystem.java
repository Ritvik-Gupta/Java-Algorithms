package src.Leetcode;

import java.util.HashMap;
import java.util.TreeMap;

public class DesignUndergroundSystem {

}

class CheckIn {
    String startStation;
    int startTime;

    CheckIn(String s, int t) {
        startStation = s;
        startTime = t;
    }
}

class AvgTime {
    double average = 0.0;
    double totalTimes = 0.0;

    void addCustomerTime(double time) {
        average = (average * totalTimes + time) / (totalTimes + 1);
        ++totalTimes;
    }
}

class StationGroup {
    String startStation, endStation;

    StationGroup(String s, String e) {
        startStation = s;
        endStation = e;
    }
}

class UndergroundSystem {
    HashMap<Integer, CheckIn> checkIns = new HashMap<>();
    TreeMap<StationGroup, AvgTime> avgStationTime = new TreeMap<>((a, b) -> {
        int comp = a.startStation.compareTo(b.startStation);
        if (comp == 0)
            return a.endStation.compareTo(b.endStation);
        return comp;
    });

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int startTime) {
        checkIns.put(id, new CheckIn(stationName, startTime));
    }

    public void checkOut(int id, String endStation, int endTime) {
        CheckIn checkInDetails = checkIns.remove(id);
        StationGroup travelId = new StationGroup(checkInDetails.startStation, endStation);

        AvgTime prevAvgTime = avgStationTime.getOrDefault(travelId, new AvgTime());
        prevAvgTime.addCustomerTime(endTime - checkInDetails.startTime);
        avgStationTime.put(travelId, prevAvgTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        return avgStationTime.get(new StationGroup(startStation, endStation)).average;
    }
}
