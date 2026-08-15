class Solution {
    public int maximumAmount(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // One coin
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }

        // Build for increasing subarray length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                int left = arr[i];

                if (i + 2 <= j) {
                    left += Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                } else {
                    left += 0;
                }

                int right = arr[j];

                if (i <= j - 2) {
                    right += Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                } else {
                    right += 0;
                }

                dp[i][j] = Math.max(left, right);
            }
        }

        return dp[0][n - 1];
    }
}