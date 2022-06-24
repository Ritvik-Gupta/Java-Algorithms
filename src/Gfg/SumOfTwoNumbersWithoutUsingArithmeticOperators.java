package src.Gfg;

public class SumOfTwoNumbersWithoutUsingArithmeticOperators {

}

class Solution {
    int sum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }
}
