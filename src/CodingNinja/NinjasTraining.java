package src.CodingNinja;

public class NinjasTraining {

}

class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[] prevDayDp = new int[4];
        int[] dp = new int[4];

        prevDayDp[0] = Math.max(points[0][1], points[0][2]);
        prevDayDp[1] = Math.max(points[0][0], points[0][2]);
        prevDayDp[2] = Math.max(points[0][0], points[0][1]);
        prevDayDp[3] = Math.max(prevDayDp[0], prevDayDp[1]);

        for (int day = 1; day < n; ++day) {
            for (int last = 0; last < 4; ++last) {
                dp[last] = 0;

                for (int task = 0; task < 3; ++task)
                    if (last != task)
                        dp[last] = Math.max(dp[last], points[day][task] + prevDayDp[task]);
            }

            int[] temp = dp;
            dp = prevDayDp;
            prevDayDp = temp;
        }

        return prevDayDp[3];
    }

}
