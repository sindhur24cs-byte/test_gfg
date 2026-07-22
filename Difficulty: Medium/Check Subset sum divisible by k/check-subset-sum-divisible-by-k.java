class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        boolean[] dp = new boolean[k];

        for (int num : arr) {
            boolean[] next = dp.clone();

            int rem = num % k;

            // Subset containing only this element
            next[rem] = true;

            // Add current element to previous subsets
            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    next[(r + rem) % k] = true;
                }
            }

            dp = next;

            if (dp[0]) {
                return true;
            }
        }

        return false;
    }
}