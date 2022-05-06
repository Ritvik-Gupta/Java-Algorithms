package src.Leetcode;

import java.util.ArrayDeque;

public class RemoveAllAdjacentDuplicatesInString2 {

}

class Solution {
    class FrequentChar {
        char character;
        int numTimes = 1;

        FrequentChar(char c) {
            character = c;
        }
    }

    public String removeDuplicates(String s, int k) {
        ArrayDeque<FrequentChar> frequentCharStack = new ArrayDeque<>(s.length() / k);

        for (int i = 0; i < s.length(); ++i) {
            char character = s.charAt(i);
            var topFreqChar = frequentCharStack.peek();

            if (topFreqChar != null && topFreqChar.character == character) {
                topFreqChar.numTimes += 1;
                if (topFreqChar.numTimes == k)
                    frequentCharStack.pop();
            } else
                frequentCharStack.push(new FrequentChar(character));
        }

        StringBuilder builder = new StringBuilder(frequentCharStack.size());
        while (!frequentCharStack.isEmpty()) {
            var topFreqChar = frequentCharStack.pollLast();
            for (int i = 0; i < topFreqChar.numTimes; ++i)
                builder.append(topFreqChar.character);
        }
        return builder.toString();
    }
}
