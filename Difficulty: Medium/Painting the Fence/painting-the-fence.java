class Solution {
    public int countWays(int n, int k) {
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return k * k;
        }

        int same = k;          // First two posts have same color
        int different = k * (k - 1); // First two have different colors

        for (int i = 3; i <= n; i++) {
            int newSame = different;
            int newDifferent = (same + different) * (k - 1);

            same = newSame;
            different = newDifferent;
        }

        return same + different;
    }
}