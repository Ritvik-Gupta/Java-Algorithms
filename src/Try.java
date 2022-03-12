package src;

import java.util.Scanner;

public class Try {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
        System.out.println(Math.pow(2, n));
        sc.close();
    }

    static long reduceNum(long num) {
        long sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    static int solve(int N) {
        long x = (long) Math.pow(2, N);
        while (x >= 10)
            x = reduceNum(x);
        return (int) x;
    }
}
