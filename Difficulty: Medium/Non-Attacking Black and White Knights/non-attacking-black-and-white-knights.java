public class Solution {
    public long numOfWays(int n, int m) {
        long N = (long) n * m;
        long totalPairs = N * (N - 1);
        long attackingPairs = 0;

        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                        attackingPairs++;
                    }
                }
            }
        }

        return totalPairs - attackingPairs;
    }
}