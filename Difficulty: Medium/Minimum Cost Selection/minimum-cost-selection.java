class Solution {
    public int minCost(int[][] mat) {
        int n = mat.length;

        int choice0 = mat[0][0];
        int choice1 = mat[0][1];
        int choice2 = mat[0][2];

        for (int i = 1; i < n; i++) {
            int new0 = mat[i][0] + Math.min(choice1, choice2);
            int new1 = mat[i][1] + Math.min(choice0, choice2);
            int new2 = mat[i][2] + Math.min(choice0, choice1);

            choice0 = new0;
            choice1 = new1;
            choice2 = new2;
        }

        return Math.min(choice0, Math.min(choice1, choice2));
    }
}