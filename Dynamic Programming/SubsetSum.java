public class SubsetSum {
    public boolean subsetSum(int sum, int[] arr) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true; // no elements, sum=0 → true
                } else if (i == 0) {
                    dp[i][j] = false; // no elements, positive sum → false
                } else if (j == 0) {
                    dp[i][j] = true; // any elements, sum=0 → true
                } else if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

}
