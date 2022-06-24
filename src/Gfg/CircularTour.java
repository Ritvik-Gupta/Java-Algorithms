package src.Gfg;

public class CircularTour {

}

class Solution {
    int tour(int petrol[], int distance[]) {
        int numStops = 0;

        int delta = 0, requiredPetrol = 0, startIdx = 0;
        for (int i = startIdx; i < numStops; i++) {
            delta += petrol[i] - distance[i];
            if (delta < 0) {
                requiredPetrol += delta;
                delta = 0;
                startIdx = i + 1;
            }
        }

        if (requiredPetrol + delta >= 0)
            return startIdx;
        return -1;
    }
}
