class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        long MOD = 1000000007;
        int zeroCount = 0;
        int negativeCount = 0;
        int maxNegative = Integer.MIN_VALUE;
        long product = 1;

        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
                continue;
            }

            if (num < 0) {
                negativeCount++;
                maxNegative = Math.max(maxNegative, num);
            }

            product = (product * num) % MOD;
        }

        // All elements are zeros
        if (zeroCount == n) {
            return 0;
        }

        // Only one negative and rest are zeros (e.g., [-1, 0, 0])
        if (negativeCount == 1 && zeroCount + negativeCount == n) {
            return 0;
        }

        // Odd count of negative numbers -> remove the maximum negative (closest to 0)
        if (negativeCount % 2 != 0) {
            product = (product * powerMod(maxNegative, MOD - 2, MOD)) % MOD;
        }

        return (int) ((product + MOD) % MOD);
    }

    private long powerMod(long base, long exp, long mod) {
        long res = 1;
        base = (base % mod + mod) % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}