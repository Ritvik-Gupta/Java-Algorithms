package src.Leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {
}

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int totalBoats = 0;
        int lowerPtr = 0, upperPtr = people.length - 1;
        while (lowerPtr <= upperPtr) {
            if (people[lowerPtr] + people[upperPtr] <= limit)
                ++lowerPtr;
            --upperPtr;
            ++totalBoats;
        }

        return totalBoats;
    }
}
