package src.Leetcode.WeeklyContest284;

import java.util.HashSet;

public class CountArtifactsThatCanBeExtracted {

}

class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        HashSet<Integer> digLocations = new HashSet<>();

        for (int[] digLocation : dig)
            digLocations.add(digLocation[0] + digLocation[1] * n);

        int totalDigged = 0;
        for (int[] artifact : artifacts) {
            int r1 = artifact[0], c1 = artifact[1], r2 = artifact[2], c2 = artifact[3];

            boolean couldDig = true;
            if (r1 == r2) {
                for (int ci = c1; ci <= c2; ++ci)
                    if (!digLocations.remove(r2 + n * ci)) {
                        couldDig = false;
                        break;
                    }
            } else if (c1 == c2) {
                for (int ri = r1; ri <= r2; ++ri)
                    if (!digLocations.remove(ri + n * c2)) {
                        couldDig = false;
                        break;
                    }
            } else if (r2 == r1 + 1 && c2 == c1 + 1) {
                if (!digLocations.remove(r1 + n * c1) ||
                        !digLocations.remove(r1 + n * c2) ||
                        !digLocations.remove(r2 + n * c1) ||
                        !digLocations.remove(r2 + n * c2))
                    couldDig = false;
            } else {
                throw new Error();
            }

            if (couldDig)
                ++totalDigged;
        }

        return totalDigged;
    }
}
