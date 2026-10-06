class Solution {
    public int longIncPath(int[][] matrix, int n, int m) {

        int[][] indegree = new int[n][m];
        int[][] dp = new int[n][m];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        java.util.ArrayDeque<Integer> q = new java.util.ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                dp[i][j] = 1;

                for (int k = 0; k < 4; k++) {
                    int ni = i + dr[k];
                    int nj = j + dc[k];

                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                        if (matrix[ni][nj] < matrix[i][j]) {
                            indegree[i][j]++;
                        }
                    }
                }

                if (indegree[i][j] == 0) {
                    q.add(i * m + j);
                }
            }
        }

        int ans = 1;

        while (!q.isEmpty()) {
            int cell = q.poll();

            int r = cell / m;
            int c = cell % m;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    if (matrix[nr][nc] > matrix[r][c]) {

                        dp[nr][nc] = Math.max(
                            dp[nr][nc],
                            dp[r][c] + 1
                        );

                        indegree[nr][nc]--;

                        if (indegree[nr][nc] == 0) {
                            q.add(nr * m + nc);
                        }

                        ans = Math.max(ans, dp[nr][nc]);
                    }
                }
            }
        }

        return ans;
    }
}
