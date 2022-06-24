package src.Gfg;

import java.util.ArrayList;

public class GrayCode {

}

class Solution {
    int getFirstBitIdx(int num) {
        int idx = 0;
        while (num > 0) {
            int bit = num & 1;
            if (bit == 1)
                return idx;

            num >>= 1;
            idx += 1;
        }
        return idx;
    }

    public ArrayList<String> graycode(int n) {
        int totalCombinations = 1 << n;
        ArrayList<String> result = new ArrayList<>(totalCombinations);

        char[] combiantion = new char[n];
        for (int i = 0; i < n; ++i)
            combiantion[i] = '0';
        result.add(String.valueOf(combiantion));

        for (int i = 1; i < totalCombinations; ++i) {
            int flippintBitIdx = n - 1 - getFirstBitIdx(i);
            combiantion[flippintBitIdx] = combiantion[flippintBitIdx] == '0' ? '1' : '0';
            result.add(String.valueOf(combiantion));
        }

        return result;
    }
}
