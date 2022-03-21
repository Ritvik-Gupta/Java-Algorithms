package src.Leetcode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class MaximumFrequencyStack {

}

class FreqPair {
    int element;
    ArrayDeque<Integer> stackPointers;

    FreqPair(int element, int firstStackPointer) {
        this.element = element;
        this.stackPointers = new ArrayDeque<>();
        this.stackPointers.add(firstStackPointer);
    }
}

class FreqStack {
    int stackPointer = 0;
    PriorityQueue<FreqPair> frequencyPriority;

    public FreqStack() {
        this.frequencyPriority = new PriorityQueue<>((a, b) -> {
            if(a.stackPointers.size() > b.stackPointers.size())
            return 1;
            if(a.stackPointers.size() < b.stackPointers.size())
            return -1;
            else {
                if (a.stackPointers.getLast() > b.stackPointers.getLast())
                    return 1;
                if (a.stackPointers.getLast() < b.stackPointers.getLast())
                    return -1;
                return 0;
            }
        });
    }

    public void push(int val) {
        this.stackPointer += 1;
    }

    public int pop() {
        return -1;
    }
}
