package src.CodeChef.DecemberrLunchtime2021;

import java.util.Scanner;

public class RomanticReversals {
    private static final Scanner S = new Scanner(System.in);

    public static void main(String[] args) {
        for (int testCase = S.nextInt(); testCase-- > 0;) {
            int n = S.nextInt(), k = S.nextInt();
            String finalStr = S.next();

            int jumpIdx = k / 2;
            int jumpOffset = k % 2 == 0 ? -1 : 1;
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < k; ++i) {
                str.append(finalStr.charAt(jumpIdx));
                jumpIdx += jumpOffset;
                if (jumpOffset < 0)
                    jumpOffset -= 1;
                else
                    jumpOffset += 1;
                jumpOffset *= -1;
            }
            str.append(finalStr.subSequence(k, n));
            System.out.println(str.toString());
        }
    }
}
