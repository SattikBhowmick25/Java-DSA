
import java.util.Arrays;

public class LongestCommonSubsequence1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public int longestCommonSubsequenceMem(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return lcsHelper(text1, text2, n, m, dp);
    }

    private static int lcsHelper(String text1, String text2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0)
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            return dp[i][j] = 1 + lcsHelper(text1, text2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(
                    lcsHelper(text1, text2, i - 1, j, dp),
                    lcsHelper(text1, text2, i, j - 1, dp));
        }
    }

}
