import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 0, c = 0;
        int dir = 0;

        while (true) {
            if (mat[r][c] == 1) {
                dir = (dir + 1) % 4;
                mat[r][c] = 0;
            }

            int nextR = r + dr[dir];
            int nextC = c + dc[dir];

            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
                List<Integer> result = new ArrayList<>();
                result.add(r);
                result.add(c);
                return result;
            }

            r = nextR;
            c = nextC;
        }
    }
}