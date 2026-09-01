class Solution {
    static final long MOD = 1000000007L;

    public long palindromicStrings(int n, int k) {
        long ans = 0;
        long[] perm = new long[k + 1];

        perm[0] = 1;

        for (int i = 1; i <= k; i++) {
            perm[i] = perm[i - 1] * (k - i + 1) % MOD;
        }

        for (int len = 1; len <= n; len++) {
            int half = len / 2;

            if (half > k) continue;

            if (len % 2 == 0) {
                ans = (ans + perm[half]) % MOD;
            } else {
                long ways = perm[half] * (k - half) % MOD;
                ans = (ans + ways) % MOD;
            }
        }

        return ans;
    }
}