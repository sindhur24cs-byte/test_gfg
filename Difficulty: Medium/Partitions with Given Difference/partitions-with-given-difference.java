class Solution {
    public int countPartitions(int[] arr, int diff) {
        int sum = 0;
        for (int x : arr) sum += x;

        if (diff > sum || ((sum + diff) & 1) == 1)
            return 0;

        int target = (sum + diff) / 2;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}