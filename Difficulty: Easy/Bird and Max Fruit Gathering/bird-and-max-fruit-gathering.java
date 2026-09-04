import java.util.*;

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        int sum = 0;

        // First window
        for (int i = 0; i < m; i++) {
            sum += arr.get(i);
        }

        int ans = sum;

        // Circular sliding window
        for (int i = m; i < n + m - 1; i++) {
            sum += arr.get(i % n);
            sum -= arr.get((i - m) % n);

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}