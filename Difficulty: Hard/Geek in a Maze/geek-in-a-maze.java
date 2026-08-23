import java.util.*;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        // dist[i][j] = minimum number of upward moves
        // required to reach cell (i, j)
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // 0-1 BFS
        Deque<int[]> dq = new ArrayDeque<>();

        dist[r][c] = 0;
        dq.offerFirst(new int[]{r, c});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!dq.isEmpty()) {

            int[] cur = dq.pollFirst();

            int x = cur[0];
            int y = cur[1];

            int upUsed = dist[x][y];

            for (int k = 0; k < 4; k++) {

                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (mat[nx][ny] == '#') {
                    continue;
                }

                int extraUp = 0;

                // Moving upward
                if (nx < x) {
                    extraUp = 1;
                }

                int newUp = upUsed + extraUp;

                // Only upward limit is checked during traversal
                if (newUp > u) {
                    continue;
                }

                // Found a better path to this cell
                if (newUp < dist[nx][ny]) {

                    dist[nx][ny] = newUp;

                    if (extraUp == 0) {
                        dq.offerFirst(new int[]{nx, ny});
                    } else {
                        dq.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }

        int answer = 0;

        // Now check the downward constraint
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == '#') {
                    continue;
                }

                if (dist[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                int upUsed = dist[i][j];

                /*
                 * down - up = i - r
                 *
                 * Therefore:
                 * down = up + i - r
                 */
                int downUsed = upUsed + (i - r);

                if (downUsed >= 0 && downUsed <= d) {
                    answer++;
                }
            }
        }

        return answer;
    }
}