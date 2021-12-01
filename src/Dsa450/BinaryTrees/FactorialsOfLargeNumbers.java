package src.Dsa450.BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;

public class FactorialsOfLargeNumbers {

}

class Solution {
    static ArrayList<Integer> factorial(int N) {
        LargeNumber result = new LargeNumber();
        result.addDigit(1);

        for (int i = 1; i <= N; ++i) {
            LargeNumber multiplicationResult = new LargeNumber();
            for (int padding = 0, num = i; num > 0; ++padding, num /= 10) {
                multiplicationResult = LargeNumber.add(
                    multiplicationResult,
                    result.multiplyDigitWithPadding(num % 10, padding)
                );
            }
            result = multiplicationResult;
        }

        Collections.reverse(result.store);
        return result.store;
    }

    private static class LargeNumber {
        ArrayList<Integer> store = new ArrayList<>();

        int totalDigits() {
            return store.size();
        }

        void addDigit(int digit) {
            store.add(digit);
        }

        int getDigitAt(int idx) {
            try {
                return store.get(idx);
            } catch (Error __) {
                return 0;
            }
        }

        static LargeNumber add(LargeNumber numA, LargeNumber numB) {
            LargeNumber result = new LargeNumber();
            if (numA.totalDigits() < numB.totalDigits()) {
                LargeNumber temp = numA;
                numA = numB;
                numB = temp;
            }

            int carry = 0;
            for (int idx = 0; idx < numA.totalDigits(); ++idx) {
                int sum = numA.getDigitAt(idx) + numB.getDigitAt(idx) + carry;
                carry = sum / 10;
                result.addDigit(sum % 10);
            }
            if (carry != 0)
                result.addDigit(carry);

            return result;
        }

        LargeNumber multiplyDigitWithPadding(int digit, int padding) {
            LargeNumber result = new LargeNumber();
            for (int i = 0; i < padding; ++i)
                result.addDigit(0);

            int carry = 0;
            for (int idx = 0; idx < totalDigits(); ++idx) {
                int product = getDigitAt(idx) * digit + carry;
                carry = product / 10;
                result.addDigit(product % 10);
            }
            if (carry != 0)
                result.addDigit(carry);

            return result;
        }
    }
}
