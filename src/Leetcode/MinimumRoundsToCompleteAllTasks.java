package src.Leetcode;

import java.util.HashMap;

public class MinimumRoundsToCompleteAllTasks {

}

class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> tasksFreq = new HashMap<>();
        for (int task : tasks)
            tasksFreq.put(task, tasksFreq.getOrDefault(task, 0) + 1);

        int totalRounds = 0;
        for (int diffTaskFreq : tasksFreq.values()) {
            if (diffTaskFreq == 1)
                return -1;
            totalRounds += (diffTaskFreq + 2) / 3;
        }

        return totalRounds;
    }
}
