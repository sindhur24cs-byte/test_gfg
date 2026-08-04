class Solution {
    public int maximumPoints(int[][] mat) {
        int n = mat.length;

        int[] prev = new int[4];

        prev[0] = Math.max(mat[0][1], mat[0][2]);
        prev[1] = Math.max(mat[0][0], mat[0][2]);
        prev[2] = Math.max(mat[0][0], mat[0][1]);
        prev[3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));

        for (int day = 1; day < n; day++) {
            int[] curr = new int[4];

            for (int last = 0; last < 4; last++) {
                curr[last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        curr[last] = Math.max(curr[last], mat[day][task] + prev[task]);
                    }
                }
            }

            prev = curr;
        }

        return prev[3];
    }
}