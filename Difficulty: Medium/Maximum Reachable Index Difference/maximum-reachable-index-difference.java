class Solution {
    public int maxIndexDifference(String s) {
        int[] dp = new int[26];

        for (int i = 0; i < 26; i++)
            dp[i] = -1;

        int ans = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';
            int end = i;

            if (ch < 25 && dp[ch + 1] != -1)
                end = dp[ch + 1];

            dp[ch] = Math.max(dp[ch], end);

            if (ch == 0)
                ans = Math.max(ans, end - i);
        }

        return ans;
    }
}