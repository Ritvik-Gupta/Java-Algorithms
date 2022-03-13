package src.Leetcode;

public class DetectCapital {

}

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;

        int startFrom = 1;
        boolean shouldAllBeUpperCase = false;

        if (Character.isUpperCase(word.charAt(0))) {
            shouldAllBeUpperCase = Character.isUpperCase(word.charAt(1));
            startFrom = 2;
        }

        for (int i = startFrom; i < word.length(); ++i)
            if (Character.isUpperCase(word.charAt(i)) != shouldAllBeUpperCase)
                return false;

        return true;
    }
}
