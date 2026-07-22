public class Solution {
    private static final int MOD = 1_000_000_007;

    public int computeValue(int n) {
        long num = factorial(2 * n);
        long den = factorial(n);

        long denSquared = (den * den) % MOD;
        long denInverse = power(denSquared, MOD - 2);

        return (int) ((num * denInverse) % MOD);
    }

    private long factorial(int num) {
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact = (fact * i) % MOD;
        }
        return fact;
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}