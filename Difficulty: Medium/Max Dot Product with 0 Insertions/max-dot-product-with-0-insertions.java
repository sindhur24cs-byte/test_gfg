class Solution {
    public long maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        long NEG = Long.MIN_VALUE / 2;
        long[][] dp = new long[n + 1][m + 1];

        // Initially, all states are impossible
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = NEG;
            }
        }

        // Matching 0 elements of b gives dot product 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {

                // Insert 0 in b, so a[i-1] is unused
                dp[i][j] = dp[i - 1][j];

                // Match a[i-1] with b[j-1]
                dp[i][j] = Math.max(
                    dp[i][j],
                    dp[i - 1][j - 1] + (long) a[i - 1] * b[j - 1]
                );
            }
        }

        return dp[n][m];
    }
}