
public class Knapsack01 {
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] t = new int[n + 1][W + 1];

        // Initialize memoization table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                t[i][j] = -1;
            }
        }

        // Start recursion using the same function
        return knapsack(W, n, val, wt, t);
    }

    // Overloaded version (same function name)
    private static int knapsack(int w, int n, int val[], int wt[], int[][] t) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (t[n][w] != -1) {
            return t[n][w];
        }

        if (wt[n - 1] <= w) {
            t[n][w] = Math.max(
                    val[n - 1] + knapsack(w - wt[n - 1], n - 1, val, wt, t),
                    knapsack(w, n - 1, val, wt, t));
        } else {
            t[n][w] = knapsack(w, n - 1, val, wt, t);
        }

        return t[n][w];
    }
}
