public class RodCutting {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        // int capacity=n; Total length of the rod
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = i + 1;
        }
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (len[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][n];
    }
}
