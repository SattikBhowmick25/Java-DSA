
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

    // Top down approach
    static int knapsackTopDown(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1]; // dp[i][j] → max value using first i items and capacity j

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // base case: 0 items or 0 capacity
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]],
                            dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    static int knapsackOptimized(int W, int val[], int wt[]) {
        int n = val.length;
        int[] dp = new int[W + 1]; // Step 1: Initialize

        // Step 2: Process each item
        for (int i = 0; i < n; i++) {

            // Step 3: Traverse capacity backwards
            for (int j = W; j >= wt[i]; j--) {

                // Step 4: Update DP value (take or skip item)
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }

        // Step 5: Final result
        return dp[W];
    }

}
