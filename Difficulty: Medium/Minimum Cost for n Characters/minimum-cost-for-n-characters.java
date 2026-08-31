import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Long> memo = new HashMap<>();

    public long minCost(int n, long i, long d, long c) {
        return solve(n, i, d, c);
    }

    private long solve(int n, long i, long d, long c) {
        if (n <= 0) return 0;
        if (n == 1) return i;
        if (memo.containsKey(n)) return memo.get(n);

        long result;
        if (n % 2 == 0) {
            // Even n: double from n / 2, or construct via 1-char inserts from 0
            // (n * i caps cost if copy-pasting is worse than simple insertions)
            result = Math.min((long) n * i, solve(n / 2, i, d, c) + c);
        } else {
            // Odd n: double to n-1 then insert 1 char, OR double to n+1 then delete 1 char
            long option1 = solve((n - 1) / 2, i, d, c) + c + i;
            long option2 = solve((n + 1) / 2, i, d, c) + c + d;
            long directInsertions = (long) n * i;

            result = Math.min(directInsertions, Math.min(option1, option2));
        }

        memo.put(n, result);
        return result;
    }
}