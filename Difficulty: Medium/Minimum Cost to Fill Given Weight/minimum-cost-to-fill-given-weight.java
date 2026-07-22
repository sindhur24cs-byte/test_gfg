import java.util.Arrays;

public class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int[] dp = new int[w + 1];

        // Initialize DP array with infinity
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: 0 kg costs 0

        // Process each packet type of weight (i + 1)
        for (int i = 0; i < n; i++) {
            int packetWeight = i + 1;
            int packetCost = cost[i];

            // Ignore unavailable packets
            if (packetCost == -1) continue;

            // Update DP table for all reachable weights starting from packetWeight
            for (int j = packetWeight; j <= w; j++) {
                if (dp[j - packetWeight] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], packetCost + dp[j - packetWeight]);
                }
            }
        }

        return dp[w] == Integer.MAX_VALUE ? -1 : dp[w];
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] cost1 = {20, 10, 4, 50, 100};
        System.out.println(solver.minimumCost(cost1, 5)); // Output: 14

        int[] cost2 = {-1, -1, 4, 3, -1};
        System.out.println(solver.minimumCost(cost2, 5)); // Output: -1
    }
}