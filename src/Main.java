package src;

import java.util.Scanner;

class Main {
    private static final int DIGIT_OFFSET = '0';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int k = sc.nextInt();
        sc.close();

        System.out.println(sumOfKthDigits(n, k));
    }

    
    private static int sumOfKthDigits(String largeNumber, int skipDigits) {
        if (skipDigits > largeNumber.length() || skipDigits <= 0)
            return -1;

        int sum = 0;
        for (int idx = 1; idx <= largeNumber.length(); ++idx)
            if (idx % skipDigits == 0) {
                int digit = largeNumber.charAt(idx - 1) - DIGIT_OFFSET;
                sum += digit;
            }

        return sum;
    }
}
