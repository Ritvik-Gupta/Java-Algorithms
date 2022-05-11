package src;

import java.util.Scanner;

/*
? Take any number of pairs of (a, b) values
? On each line A and B is given space separated
? Define a MyCalculator class for power operation and compute a^b
? If a or b is negative throw and state the Exception 
? If a and b are zero throw and state the Exception 
? Otherwise print on each line the result of a^b
*/
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var myCalcy = new MyCalculator();

        while (sc.hasNext()) {
            try {
                System.out.println(myCalcy.power(sc.nextInt(), sc.nextInt()));
            } catch (Exception except) {
                System.out.println(except);
            }
        }
    }
}

class MyCalculator {
    public long power(int a, int b) throws Exception {
        if (a < 0 || b < 0)
            throw new Exception("a or b should not be negative");
        if (a == 0 && b == 0)
            throw new Exception("a and b cannot be zero");

        return (long) Math.pow((long) a, (long) b);
    }
}
