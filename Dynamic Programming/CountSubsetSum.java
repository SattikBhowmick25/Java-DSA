public class CountSubsetSum {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        int MOD = (int) (1e9 + 7);

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1; // empty subset
                } else if (i == 0) {
                    dp[i][j] = 0; // no elements, positive sum
                } else if (nums[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - nums[i - 1]]) % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}
