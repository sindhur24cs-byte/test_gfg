class Solution {
    public int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] unsafe = new boolean[n][m];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    unsafe[i][j] = true;

                    for (int k = 0; k < 4; k++) {
                        int ni = i + dr[k];
                        int nj = j + dc[k];

                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            unsafe[ni][nj] = true;
                        }
                    }
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        java.util.Queue<int[]> q = new java.util.LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!unsafe[i][0]) {
                q.add(new int[]{i, 0});
                visited[i][0] = true;
            }
        }

        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                if (c == m - 1) {
                    return steps;
                }

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m
                            && !unsafe[nr][nc] && !visited[nr][nc]) {

                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}