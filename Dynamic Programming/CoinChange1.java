public class CoinChange1 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        int INF = amount + 1; // "infinity"

        // Initialize first row with infinity (0 coins cannot form any positive amount)
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = INF;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    // Include the coin (stay at i because unbounded) or skip it
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j]; // Cannot include this coin
                }
            }
        }

        return dp[n][amount] > amount ? -1 : dp[n][amount];
    }
}
