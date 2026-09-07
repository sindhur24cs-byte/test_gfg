class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;

        for (int k = 0; k < n; k++) {
            int[][] next = new int[n + 1][n + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    next[i][j] = -1;
                }
            }

            for (int i = 0; i <= k; i++) {
                for (int j = 0; j <= k; j++) {

                    if (dp[i][j] == -1)
                        continue;

                    // Don't use arr[k]
                    next[i][j] = Math.max(next[i][j], dp[i][j]);

                    // Add arr[k] to increasing subsequence
                    if (i == 0 || arr[k] > arr[i - 1]) {
                        next[k + 1][j] =
                            Math.max(next[k + 1][j], dp[i][j] + 1);
                    }

                    // Add arr[k] to decreasing subsequence
                    if (j == 0 || arr[k] < arr[j - 1]) {
                        next[i][k + 1] =
                            Math.max(next[i][k + 1], dp[i][j] + 1);
                    }
                }
            }

            dp = next;
        }

        int maxUsed = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                maxUsed = Math.max(maxUsed, dp[i][j]);
            }
        }

        return n - maxUsed;
    }
}