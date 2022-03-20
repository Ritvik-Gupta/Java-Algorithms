package src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        System.out.println(reductionCost(new ArrayList<>() {
            {
                add(1);
                add(2);
                add(3);
            }
        }));
    }

    public static int reductionCost(List<Integer> nums) {
        PriorityQueue<Integer> numsQueue = new PriorityQueue<>(nums.size());
        nums.forEach(numsQueue::offer);

        int cost = 0;
        while (numsQueue.size() > 1) {
            int sum = numsQueue.poll() + numsQueue.poll();
            cost += sum;
            numsQueue.offer(sum);
        }

        return cost;
    }

}
