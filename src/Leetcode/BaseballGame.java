package src.Leetcode;

import java.util.ArrayList;

public class BaseballGame {

}

class Solution {
    public int calPoints(String[] ops) {
        ArrayList<Integer> scoresRecord = new ArrayList<>(ops.length);

        for (String operation : ops) {
            switch (operation) {
                case "C":
                    scoresRecord.remove(scoresRecord.size() - 1);
                    break;
                case "D":
                    scoresRecord.add(scoresRecord.get(scoresRecord.size() - 1) * 2);
                    break;
                case "+":
                    scoresRecord.add(
                        scoresRecord.get(scoresRecord.size() - 1) + 
                        scoresRecord.get(scoresRecord.size() - 2)
                    );
                    break;
                default:
                    scoresRecord.add(Integer.parseInt(operation));
                    break;
            }
        }

        return scoresRecord.stream().reduce(0, Integer::sum);
    }
}
