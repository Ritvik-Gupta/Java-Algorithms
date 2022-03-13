package src.Leetcode;

import java.util.ArrayList;

public class NumberOfSquarefulArrays {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());

        graph.get(0).add(2);
        graph.get(2).add(0);

        graph.get(2).add(1);
        graph.get(1).add(2);
        
        graph.get(3).add(1);
        graph.get(1).add(3);
        
        graph.get(4).add(1);
        graph.get(1).add(4);
        
        graph.get(4).add(3);
        graph.get(3).add(4);

        System.out.println(graph);


        // graph.add(new ArrayList<>());
        // graph.add(new ArrayList<>());
        // graph.add(new ArrayList<>());
        // graph.add(new ArrayList<>());

        // graph.get(1).add(0);
        // graph.get(2).add(0);
        // graph.get(1).add(2);
        // graph.get(2).add(1);
        // graph.get(3).add(1);
        // graph.get(3).add(2);

        System.out.println(Solution.countHamiltonianPaths(graph));
    }
}

class Solution {
    public int numSquarefulPerms(int[] nums) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i)
            graph.add(new ArrayList<>());

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                double sqrtSum = Math.sqrt((double) nums[i] + (double) nums[j]);
                if (Math.floor(sqrtSum) == Math.ceil(sqrtSum)) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        return countHamiltonianPaths(graph);
    }

    public static int countHamiltonianPaths(ArrayList<ArrayList<Integer>> graph) {
        int N = graph.size();

        int[][] dp = new int[N][1 << N];
        dp[0][1] = 1;

        for (int i = 2; i < (1 << N); ++i) {
            if ((i & (1 << 0)) == 0)
                continue;

            if ((i & (1 << (N - 1))) != 0 && i != ((1 << N) - 1))
                continue;

            for (int end = 0; end < N; ++end) {
                if ((i & (1 << end)) == 0)
                    continue;

                int prev = i - (1 << end);

                for (int it : graph.get(end)) {
                    if ((i & (1 << it)) != 0)
                        dp[end][i] += dp[it][prev];
                }
            }
        }

        return dp[N - 1][(1 << N) - 1];
    }
}

