package src.CodeChef.DecemberrLunchtime2021;

import java.util.Scanner;

public class ChefLoves1010 {

    private static final Scanner S = new Scanner(System.in);

    public static void main(String[] args) {
        for (int testCase = S.nextInt(); testCase-- > 0;) {
            int n = S.nextByte();
            String bits = S.next();
            int numOnes = 0;
            for (int i = 0; i < n; ++i)
                if (bits.charAt(i) == '1')
                    ++numOnes;
            int numZeroes = n - numOnes;

            System.out.println(Math.max(0, Math.min(numOnes, numZeroes) - 1));
        }
    }
}
