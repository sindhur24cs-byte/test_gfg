import java.util.*;

class Solution {
    static final long MOD = 1000000007;

    public int maxAmount(int[] arr, int k) {
        Arrays.sort(arr);

        int n = arr.length;
        long ans = 0;
        int i = n - 1;

        while (k > 0 && i >= 0) {
            int current = arr[i];
            int next = i > 0 ? arr[i - 1] : 0;

            int sellers = n - i;
            long available = (long) (current - next) * sellers;

            long take = Math.min((long) k, available);

            long full = take / sellers;
            long extra = take % sellers;

            long high = current;
            long low = current - full + 1;

            long sum = (high + low) * full / 2;
            sum *= sellers;

            sum += extra * (current - full);

            ans = (ans + sum) % MOD;
            k -= take;

            if (take == available)
                i--;
            else
                break;
        }

        return (int) ans;
    }
}