
package src.Dsa450.Stack;

public class ImplementTwoStacksInAnArray {
}

class TwoStack {
    int size;
    int top1, top2;
    int arr[] = new int[100];

    TwoStack() {
        size = 100;
        top1 = -1;
        top2 = size;
    }
}

class Stacks {
    private static int SEPARATION_MULTILPLIER = 1000;

    void push1(int x, TwoStack sq) {
        if (sq.top1 == sq.size - 1)
            return;

        sq.top1 += 1;
        sq.arr[sq.top1] += x;
    }

    void push2(int x, TwoStack sq) {
        if (sq.top2 == 0)
            return;
        sq.top2 -= 1;
        sq.arr[sq.size - 1 - sq.top2] += x * SEPARATION_MULTILPLIER;
    }

    int pop1(TwoStack sq) {
        if (sq.top1 == -1)
            return -1;
        int element = sq.arr[sq.top1] % SEPARATION_MULTILPLIER;
        sq.arr[sq.top1] -= element;
        sq.top1 -= 1;
        return element;
    }

    int pop2(TwoStack sq) {
        if (sq.top2 == sq.size)
            return -1;
        int element = sq.arr[sq.size - 1 - sq.top2] / SEPARATION_MULTILPLIER;
        sq.arr[sq.size - 1 - sq.top2] -= element * SEPARATION_MULTILPLIER;
        sq.top2 += 1;
        return element;
    }
}
