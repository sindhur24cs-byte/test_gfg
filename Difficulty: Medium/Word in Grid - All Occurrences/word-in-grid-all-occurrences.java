import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                if (mat[r][c] != word.charAt(0))
                    continue;

                for (int d = 0; d < 8; d++) {
                    int x = r;
                    int y = c;
                    int k = 0;

                    while (k < word.length()) {
                        if (x < 0 || x >= n || y < 0 || y >= m)
                            break;

                        if (mat[x][y] != word.charAt(k))
                            break;

                        x += dr[d];
                        y += dc[d];
                        k++;
                    }

                    if (k == word.length()) {
                        ArrayList<Integer> position = new ArrayList<>();
                        position.add(r);
                        position.add(c);
                        ans.add(position);
                        break;
                    }
                }
            }
        }

        return ans;
    }
}