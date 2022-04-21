package src;

class Main {
    public int[] climbStairs(int n) {
        int[] stairs = new int[n + 1];

        stairs[0] = 1;

        for (int i = 0; i < n; ++i) {
            stairs[i + 1] += stairs[i];
            if (i + 2 <= n)
                stairs[i + 2] += stairs[i];
        }

        return stairs;
    }

    public static void main(String[] args) {
        int[] arr = new Main().climbStairs(46);

        for (int x : arr)
            System.out.println(x);
    }
}
