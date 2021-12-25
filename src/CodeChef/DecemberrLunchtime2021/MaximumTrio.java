package src.CodeChef.DecemberrLunchtime2021;

import java.util.Scanner;

public class MaximumTrio {
    private static final Scanner S = new Scanner(System.in);

    public static void main(String[] args) {
        for (int testCase = S.nextInt(); testCase-- > 0;) {
            int n = S.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; ++i)
                arr[i] = S.nextLong();

            int maxIdx = 0, minIdx = 0;
            for (int i = 1; i < n; ++i) {
                if (arr[i] > arr[maxIdx])
                    maxIdx = i;
                if (arr[i] < arr[minIdx])
                    minIdx = i;
            }

            int prevMaxIdx = -1;
            for (int i = 0; i < n; ++i) {
                if (i == maxIdx)
                    continue;
                if (prevMaxIdx == -1 || arr[i] > arr[prevMaxIdx])
                    prevMaxIdx = i;
            }

            long a = (arr[maxIdx] - arr[minIdx]) * arr[prevMaxIdx],
                    b = (arr[prevMaxIdx] - arr[minIdx]) * arr[maxIdx];
            if (a > b)
                System.out.println(a);
            else
                System.out.println(b);
        }
    }
}
