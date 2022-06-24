package src.Gfg;

import java.util.ArrayDeque;
import java.util.HashSet;

public class LengthOfTheLongestSubstring {

}

class Solution {
    int longestUniqueSubsttr(String str) {
        ArrayDeque<Character> substr = new ArrayDeque<>();
        HashSet<Character> seenChars = new HashSet<>();
        int longestWindowSize = 0;

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);

            if (seenChars.contains(ch)) {
                while (!substr.isEmpty()) {
                    char substrFront = substr.removeFirst();
                    seenChars.remove(substrFront);
                    if (substrFront == ch)
                        break;
                }
            }

            substr.addLast(ch);
            seenChars.add(ch);
            longestWindowSize = Math.max(longestWindowSize, substr.size());
        }

        return longestWindowSize;
    }
}
