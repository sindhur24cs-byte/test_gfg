class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;

        boolean[][] visited = new boolean[mat.length][mat[0].length];

        int ans = dfs(mat, xs, ys, xd, yd, visited);

        return ans == -1 ? -1 : ans;
    }

    private int dfs(int[][] mat, int x, int y, int xd, int yd,
                    boolean[][] visited) {

        if (x == xd && y == yd)
            return 0;

        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int max = -1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < mat.length &&
                ny >= 0 && ny < mat[0].length &&
                mat[nx][ny] == 1 &&
                !visited[nx][ny]) {

                int path = dfs(mat, nx, ny, xd, yd, visited);

                if (path != -1)
                    max = Math.max(max, path + 1);
            }
        }

        visited[x][y] = false;

        return max;
    }
}