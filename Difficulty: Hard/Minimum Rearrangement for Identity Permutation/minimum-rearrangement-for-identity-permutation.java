class Solution {
    static final long MOD = 1000000007;

    public int minOperations(int[] b) {
        int n = b.length;
        boolean[] visited = new boolean[n];
        long ans = 1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int current = i;
                int length = 0;

                while (!visited[current]) {
                    visited[current] = true;
                    current = b[current] - 1;
                    length++;
                }

                ans = lcm(ans, length);
            }
        }

        return (int) ans;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    long lcm(long a, long b) {
        return (a / gcd(a, b) * b) % MOD;
    }
}