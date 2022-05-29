package src.Leetcode.WeeklyContest295;

import java.util.HashMap;

public class RearrangeCharactersToMakeTargetString {

}

class Solution {
    public int rearrangeCharacters(String str, String target) {
        HashMap<Character, Integer> letterFreq = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            letterFreq.put(ch, 1 + letterFreq.getOrDefault(ch, 0));
        }

        HashMap<Character, Integer> targetLetterFreq = new HashMap<>();
        for (int i = 0; i < target.length(); ++i) {
            char ch = target.charAt(i);
            targetLetterFreq.put(ch, 1 + targetLetterFreq.getOrDefault(ch, 0));
        }

        int maxCopies = Integer.MAX_VALUE;
        for (var entry: targetLetterFreq.entrySet()) {
            char ch = entry.getKey();
            int targetFreq = entry.getValue();

            maxCopies = Math.min(maxCopies, letterFreq.getOrDefault(ch, 0) / targetFreq);
        }

        return maxCopies;
    }
}
