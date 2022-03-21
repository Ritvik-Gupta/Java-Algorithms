package src.Leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters {

}

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++)
            lastIndex[s.charAt(i) - 'a'] = i;

        boolean[] hasVisitedChar = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            if (hasVisitedChar[charIndex])
                continue;

            while (!stack.isEmpty() && charIndex < stack.peek() && i < lastIndex[stack.peek()])
                hasVisitedChar[stack.pop()] = false;

            stack.push(charIndex);
            hasVisitedChar[charIndex] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append((char) (stack.pop() + 'a'));
        return sb.reverse().toString();
    }
}
