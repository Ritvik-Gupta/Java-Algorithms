package src;

import java.security.Permissions;
import java.util.PriorityQueue;

public class Try {
    public static void main(String[] args) {
        class A {
            int b;

            A(int b) {
                this.b=b;
            }
        }

        PriorityQueue<A> a = new PriorityQueue<>((x, y)->x.b-y.b);
        a.add(new A(1));
        a.add(new A(4));
        a.add(new A(-1));
        a.add(new A(9));


        while(!a.isEmpty()) {
            System.out.println(a.poll().b);
        }
    }
}
