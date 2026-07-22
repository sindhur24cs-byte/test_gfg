import java.util.*;

class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        for (int[] x : arr) {
            rows[x[0] - 1] = true;
            cols[x[1] - 1] = true;
        }

        int maxRow = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (rows[i]) {
                maxRow = Math.max(maxRow, count);
                count = 0;
            } else {
                count++;
            }
        }

        maxRow = Math.max(maxRow, count);

        int maxCol = 0;
        count = 0;

        for (int j = 0; j < m; j++) {
            if (cols[j]) {
                maxCol = Math.max(maxCol, count);
                count = 0;
            } else {
                count++;
            }
        }

        maxCol = Math.max(maxCol, count);

        return maxRow * maxCol;
    }
}