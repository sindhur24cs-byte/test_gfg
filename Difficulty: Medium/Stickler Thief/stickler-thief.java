class Solution {
    public int findMaxSum(int arr[]) {
        int n = arr.length;

        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];

        int prev2 = 0;       // dp[i-2]
        int prev1 = arr[0];  // dp[i-1]

        for (int i = 1; i < n; i++) {
            int take = arr[i] + prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}