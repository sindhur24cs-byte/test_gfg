import java.util.*;

class Solution {
    public int countCoordinates(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            p[i][0] = true;
            queue.add(new int[]{i, 0});
        }

        for (int j = 0; j < m; j++) {
            if (!p[0][j]) {
                p[0][j] = true;
                queue.add(new int[]{0, j});
            }
        }

        bfs(mat, p, queue);

        queue.clear();

        for (int i = 0; i < n; i++) {
            q[i][m - 1] = true;
            queue.add(new int[]{i, m - 1});
        }

        for (int j = 0; j < m; j++) {
            if (!q[n - 1][j]) {
                q[n - 1][j] = true;
                queue.add(new int[]{n - 1, j});
            }
        }

        bfs(mat, q, queue);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j])
                    ans++;
            }
        }

        return ans;
    }

    void bfs(int[][] mat, boolean[][] visited, Queue<int[]> queue) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < m &&
                    !visited[nx][ny] &&
                    mat[nx][ny] >= mat[x][y]) {

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}