package src.Leetcode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Collectors;

public class ReplaceNonCoprimeNumbersInArray {
}

class Solution {

    static int gcd(int x, int y) {
        if (x == 0)
            return y;
        return gcd(y % x, x);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayDeque<Integer> numsStack = new ArrayDeque<>(nums.length / 3);
        numsStack.addLast(1);
        for (int num : nums) {
            while (true) {
                long gcd = (long) gcd(numsStack.peekLast(), num);
                if (gcd == 1)
                    break;
                num = (int) ((long) numsStack.pollLast() * (long) num / gcd);
            }
            numsStack.addLast(num);
        }

        numsStack.pollFirst();
        return numsStack.stream().collect(Collectors.toList());
    }
}
