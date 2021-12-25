package src.CodeChef.DecemberrLunchtime2021;

import java.util.Scanner;

public class ChefAndVacationTransportation {
    private static final Scanner S = new Scanner(System.in);

    public static void main(String[] args) {
        for (int testCase = S.nextInt(); testCase-- > 0;) {
            long difference = S.nextLong() + S.nextLong() - S.nextLong();
            if (difference > 0)
                System.out.println("TRAIN");
            else if (difference < 0)
                System.out.println("PLANEBUS");
            else
                System.out.println("EQUAL");
        }
    }
}
