import java.util.*;

class Solution {

    public String compress(String s) {
        int n = s.length();

        // Z-function
        int[] z = new int[n];

        for (int i = 1, l = 0, r = 0; i < n; i++) {

            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n &&
                   s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        // dp[i] = minimum encoded length
        // needed to produce first i characters of s
        int INF = n + 1;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            // Add one normal character
            dp[i] = dp[i - 1] + 1;

            // Use '*' to duplicate the current string
            // Prefix must be of form X + X
            if (i % 2 == 0) {
                int half = i / 2;

                if (z[half] >= half) {
                    dp[i] = Math.min(dp[i], dp[half] + 1);
                }
            }
        }

        /*
         * best[i] = lexicographically smallest encoding
         * among encodings having exactly dp[i] characters.
         */
        String[] best = new String[n + 1];
        best[0] = "";

        for (int i = 1; i <= n; i++) {

            // Option 1: append normal character.
            // IMPORTANT: only consider it if it gives
            // the minimum length dp[i].
            if (dp[i - 1] + 1 == dp[i]) {

                best[i] = best[i - 1] + s.charAt(i - 1);
            }

            // Option 2: append '*'.
            if (i % 2 == 0) {

                int half = i / 2;

                if (z[half] >= half &&
                    dp[half] + 1 == dp[i]) {

                    String option = best[half] + "*";

                    if (best[i] == null ||
                        option.compareTo(best[i]) < 0) {

                        best[i] = option;
                    }
                }
            }
        }

        return best[n];
    }
}