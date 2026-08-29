class Solution {
    public int countSubsequences(String s, int n) {
        final int MOD = 1000000007;

        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {
            int d = ch - '0';
            long[] next = dp.clone();

            next[d % n] = (next[d % n] + 1) % MOD;

            for (int r = 0; r < n; r++) {
                if (dp[r] != 0) {
                    int nr = (r * 10 + d) % n;
                    next[nr] = (next[nr] + dp[r]) % MOD;
                }
            }

            dp = next;
        }

        return (int) dp[0];
    }
}