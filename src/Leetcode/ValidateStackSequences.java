package src.Leetcode;

import java.util.LinkedList;

public class ValidateStackSequences {

}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int pushedIdx = 0, poppedIdx = 0;

        while (pushedIdx < pushed.length) {
            stack.addFirst(pushed[pushedIdx]);
            ++pushedIdx;
            while (!stack.isEmpty() && stack.getFirst() == popped[poppedIdx]) {
                stack.removeFirst();
                ++poppedIdx;
            }
        }

        return poppedIdx == popped.length;
    }
}
