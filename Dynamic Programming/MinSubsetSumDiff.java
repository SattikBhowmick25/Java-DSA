public class MinSubsetSumDiff {
    public int minimumDifference(int[] nums) {
        int range = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            range += nums[i];
        }

        boolean[][] dp = new boolean[n + 1][range + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= range; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= range / 2; i++) {
            if (dp[n][i] == true && minDiff > (range - 2 * i)) {
                minDiff = range - 2 * i;
            }
        }
        return minDiff;
    }
}
