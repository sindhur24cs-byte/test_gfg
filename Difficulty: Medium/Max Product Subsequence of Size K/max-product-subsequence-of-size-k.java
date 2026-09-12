class Solution {
    public long maxProduct(int[] arr, int k) {
        long[][] dp = new long[k + 1][2];

        for (int i = 0; i <= k; i++) {
            dp[i][0] = Long.MIN_VALUE;
            dp[i][1] = Long.MAX_VALUE;
        }

        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int x : arr) {
            for (int j = k; j >= 1; j--) {
                if (dp[j - 1][0] != Long.MIN_VALUE) {
                    long a = dp[j - 1][0] * x;
                    long b = dp[j - 1][1] * x;

                    dp[j][0] = Math.max(dp[j][0], Math.max(a, b));
                    dp[j][1] = Math.min(dp[j][1], Math.min(a, b));
                }
            }
        }

        return dp[k][0];
    }
}