class Solution {
    static final long MOD = 1000000007L;

    public int prefixStrings(int n) {

        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + dp[j] * dp[i - 1 - j]) % MOD;
            }
        }

        return (int) dp[n];
    }
}