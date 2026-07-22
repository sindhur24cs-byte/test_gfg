class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] path = new int[n][n];

        // -1 = not calculated
        //  0 = cannot reach destination
        //  1 = can reach destination
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        if (mat[0][0] == 0 || !solve(mat, 0, 0, path, dp)) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(-1);
            ans.add(row);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(path[i][j]);
            }

            ans.add(row);
        }

        return ans;
    }

    private boolean solve(int[][] mat, int r, int c,
                          int[][] path, int[][] dp) {

        int n = mat.length;

        if (r == n - 1 && c == n - 1) {
            path[r][c] = 1;
            return true;
        }

        if (dp[r][c] != -1) {
            return dp[r][c] == 1;
        }

        path[r][c] = 1;

        int maxJump = mat[r][c];

        // Shortest jump first
        for (int jump = 1; jump <= maxJump; jump++) {

            // RIGHT first
            int nr = r;
            int nc = c + jump;

            if (nc < n && mat[nr][nc] != 0) {
                if (solve(mat, nr, nc, path, dp)) {
                    dp[r][c] = 1;
                    return true;
                }
            }

            // DOWN second
            nr = r + jump;
            nc = c;

            if (nr < n && mat[nr][nc] != 0) {
                if (solve(mat, nr, nc, path, dp)) {
                    dp[r][c] = 1;
                    return true;
                }
            }
        }

        // No path from this cell
        path[r][c] = 0;
        dp[r][c] = 0;

        return false;
    }
}