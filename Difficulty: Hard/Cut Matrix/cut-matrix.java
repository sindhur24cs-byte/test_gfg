class Solution {
    static final int MOD = 1000000007;

    public int findWays(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] sum = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                sum[i][j] = matrix[i][j]
                        + sum[i + 1][j]
                        + sum[i][j + 1]
                        - sum[i + 1][j + 1];
            }
        }

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sum[i][j] > 0)
                    dp[i][j] = 1;
            }
        }

        for (int pieces = 2; pieces <= k; pieces++) {
            int[][] next = new int[n][m];

            int[][] rowSuffix = new int[n][m + 1];
            int[][] colSuffix = new int[n + 1][m];

            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    rowSuffix[i][j] =
                            (rowSuffix[i][j + 1] + dp[i][j]) % MOD;
                }
            }

            for (int j = 0; j < m; j++) {
                for (int i = n - 1; i >= 0; i--) {
                    colSuffix[i][j] =
                            (colSuffix[i + 1][j] + dp[i][j]) % MOD;
                }
            }

            int[][] nextRow = new int[n + 1][m];
            int[][] nextCol = new int[n][m + 1];

            for (int j = 0; j < m; j++) {
                nextRow[n][j] = -1;

                for (int i = n - 1; i >= 0; i--) {
                    if (sum[i][j] - sum[i + 1][j] > 0)
                        nextRow[i][j] = i;
                    else
                        nextRow[i][j] = nextRow[i + 1][j];
                }
            }

            for (int i = 0; i < n; i++) {
                nextCol[i][m] = -1;

                for (int j = m - 1; j >= 0; j--) {
                    if (sum[i][j] - sum[i][j + 1] > 0)
                        nextCol[i][j] = j;
                    else
                        nextCol[i][j] = nextCol[i][j + 1];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (sum[i][j] == 0)
                        continue;

                    int ways = 0;

                    int r = nextRow[i][j];
                    if (r != -1 && r + 1 < n) {
                        ways += colSuffix[r + 1][j];
                        if (ways >= MOD)
                            ways -= MOD;
                    }

                    int c = nextCol[i][j];
                    if (c != -1 && c + 1 < m) {
                        ways += rowSuffix[i][c + 1];
                        if (ways >= MOD)
                            ways -= MOD;
                    }

                    next[i][j] = ways;
                }
            }

            dp = next;
        }

        return dp[0][0];
    }
}