class Solution {
    static final int MOD = 1000000007;

    public int countSubsets(int[] arr) {

        int[] freq = new int[31];
        for (int x : arr) freq[x]++;

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        int[] mask = new int[31];

        for (int num = 2; num <= 30; num++) {
            int x = num;
            int m = 0;
            boolean valid = true;

            for (int i = 0; i < 10; i++) {
                int p = primes[i];
                int cnt = 0;

                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }

                if (cnt > 1) {
                    valid = false;
                    break;
                }

                if (cnt == 1)
                    m |= (1 << i);
            }

            mask[num] = valid ? m : -1;
        }

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int num = 2; num <= 30; num++) {
            if (freq[num] == 0 || mask[num] == -1)
                continue;

            int m = mask[num];
            long[] ndp = dp.clone();

            for (int s = 0; s < (1 << 10); s++) {
                if ((s & m) == 0) {
                    ndp[s | m] = (ndp[s | m] + dp[s] * freq[num]) % MOD;
                }
            }

            dp = ndp;
        }

        long ans = 0;
        for (int s = 1; s < (1 << 10); s++)
            ans = (ans + dp[s]) % MOD;

        long pow = 1;
        for (int i = 0; i < freq[1]; i++)
            pow = (pow * 2) % MOD;

        ans = (ans * pow) % MOD;

        return (int) ans;
    }
}