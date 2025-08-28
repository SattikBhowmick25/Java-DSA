
import java.util.Arrays;

public class LongestCommonSubstring {
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0; // store the result

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0; // reset because substring must be contiguous
                }
            }
        }

        return maxLen;
    }

    public int longestCommonSubstrMem(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // initialize with -1 (uncomputed states)
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxLen[] = { 0 };
        lcsHelper(s1, s2, n, m, dp, maxLen);
        return maxLen[0];
    }

    private int lcsHelper(String s1, String s2, int i, int j, int[][] dp, int[] maxLen) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = 1 + lcsHelper(s1, s2, i - 1, j - 1, dp, maxLen);
            maxLen[0] = Math.max(maxLen[0], dp[i][j]);
        } else {
            dp[i][j] = 0; // reset because substring must be contiguous
        }

        // Explore other possibilities (move one index back in either string)
        lcsHelper(s1, s2, i - 1, j, dp, maxLen);
        lcsHelper(s1, s2, i, j - 1, dp, maxLen);

        return dp[i][j];
    }
}
