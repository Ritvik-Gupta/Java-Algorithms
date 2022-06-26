package src.Gfg;

import java.util.ArrayList;
import java.util.HashSet;

public class LuckyNumber {

}

class Solution {
    static int isLuckyOrNot(Long num) {
        ArrayList<Long> digits = new ArrayList<>();

        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }

        HashSet<Long> seenProducts = new HashSet<>();
        for (int i = 0; i < digits.size(); ++i) {
            long prod = 1;
            for (int j = i; j < digits.size(); ++j) {
                prod *= digits.get(j);
                if (!seenProducts.add(prod))
                    return 0;
            }
        }

        return 1;
    }
}
