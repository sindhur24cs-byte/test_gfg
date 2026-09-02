class Solution {
    public int solve(int n, String s) {
        boolean[] seen = new boolean[26];
        boolean[] got = new boolean[26];

        int available = n;
        int rejected = 0;

        for (char c : s.toCharArray()) {
            int x = c - 'A';

            if (!seen[x]) {
                seen[x] = true;

                if (available > 0) {
                    got[x] = true;
                    available--;
                } else {
                    rejected++;
                }
            } else {
                if (got[x]) {
                    available++;
                }
            }
        }

        return rejected;
    }
}