package src.Gfg;

public class FinalDestination {

}

class Solution {
    static int canReach(Long a, Long b, Long x) {
        long totalDistance = Math.abs(a) + Math.abs(b);

        if (x < totalDistance)
            return 0;
        long extraStepsLeft = x - totalDistance;
        return (extraStepsLeft & 1) == 0 ? 1 : 0;
    }
}
