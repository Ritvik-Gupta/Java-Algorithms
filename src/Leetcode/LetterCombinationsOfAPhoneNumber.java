package src.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

}

class PhoneCombinationBuilder {
    private static char[][] digitMapping = {
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' },
    };

    public List<String> combinations = new ArrayList<>();

    private void branchAddDigitMapping(String digits, int index, String collected) {
        if (index == digits.length()) {
            combinations.add(collected);
            return;
        }

        for (char mappedChar : digitMapping[digits.charAt(index) - '2'])
            branchAddDigitMapping(digits, index + 1, collected + mappedChar);
    }

    PhoneCombinationBuilder(String phoneNumber) {
        branchAddDigitMapping(phoneNumber, 0, "");
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return new ArrayList<>();
        return new PhoneCombinationBuilder(digits).combinations;
    }
}
