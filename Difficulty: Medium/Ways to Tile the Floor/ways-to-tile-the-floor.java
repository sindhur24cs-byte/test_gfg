class Solution {
    static final int MOD = 1000000007;

    public int countWays(int n, int m) {
        long[] dp = new long[n + 1];

        // For heights smaller than m, only horizontal placement is possible
        for (int i = 0; i < Math.min(n, m); i++) {
            dp[i] = 1;
        }

        if (n < m) {
            return 1;
        }

        dp[m - 1] = 1;

        for (int i = m; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - m]) % MOD;
        }

        return (int) dp[n];
    }
}