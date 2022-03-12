package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();

        sc.close();

        System.out.println(countSubarray(n, arr));
    }

    static long sumNumbers(long num) {
        long sum = 0;
        for (long i = 1; i <= num; ++i)
            sum += i;
        return sum;
    }

    static long countSubarray(int n, int[] arr) {
        long subArrLength = 0;
        long totalCount = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] % 2 == 0) {
                totalCount += sumNumbers(subArrLength);
                subArrLength = 0;
            } else
                ++subArrLength;
        }
        totalCount += sumNumbers(subArrLength);
        subArrLength = 0;

        return totalCount;
    }
}
