class Solution {

    public List<Integer> largestSquare(int[][] mat, int[][] queries, int k) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] pre = new int[n + 1][m + 1];

        // Prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pre[i + 1][j + 1] = mat[i][j]
                        + pre[i][j + 1]
                        + pre[i + 1][j]
                        - pre[i][j];
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {

            int r = query[0];
            int c = query[1];

            int max = Math.min(
                    Math.min(r, n - 1 - r),
                    Math.min(c, m - 1 - c)
            );

            int low = 0;
            int high = max;

            // Important: -1 means no valid square
            int best = -1;

            while (low <= high) {

                int radius = (low + high) / 2;

                int r1 = r - radius;
                int c1 = c - radius;
                int r2 = r + radius;
                int c2 = c + radius;

                int ones = pre[r2 + 1][c2 + 1]
                         - pre[r1][c2 + 1]
                         - pre[r2 + 1][c1]
                         + pre[r1][c1];

                if (ones <= k) {
                    best = radius;
                    low = radius + 1;
                } else {
                    high = radius - 1;
                }
            }

            if (best == -1) {
                ans.add(-1);
            } else {
                ans.add(2 * best + 1);
            }
        }

        return ans;
    }
}