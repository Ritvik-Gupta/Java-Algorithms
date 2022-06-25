package src.AmazonChallenge;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        System.out.println(solve(num));
    }

    private static int solve(int num) {
        PriorityQueue<Integer> digitsQueue = new PriorityQueue<>();
        while (num != 0) {
            digitsQueue.offer(num % 10);
            num /= 10;
        }

        boolean addToP1 = true;
        int p1 = 0, p2 = 0;
        while (!digitsQueue.isEmpty()) {
            if (addToP1)
                p1 = p1 * 10 + digitsQueue.poll();
            else
                p2 = p2 * 10 + digitsQueue.poll();
            addToP1 = !addToP1;
        }

        return p1 + p2;
    }
}
