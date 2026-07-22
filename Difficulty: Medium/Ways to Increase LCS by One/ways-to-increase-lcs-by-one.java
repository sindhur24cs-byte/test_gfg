class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] pref = new int[n + 1][m + 1];
        int[][] suff = new int[n + 1][m + 1];

        // LCS of prefixes
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    pref[i][j] = pref[i - 1][j - 1] + 1;
                } else {
                    pref[i][j] = Math.max(
                        pref[i - 1][j],
                        pref[i][j - 1]
                    );
                }
            }
        }

        // LCS of suffixes
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    suff[i][j] = suff[i + 1][j + 1] + 1;
                } else {
                    suff[i][j] = Math.max(
                        suff[i + 1][j],
                        suff[i][j + 1]
                    );
                }
            }
        }

        int original = pref[n][m];
        int answer = 0;

        // Try every insertion position
        for (int pos = 0; pos <= n; pos++) {

            // Try every lowercase character
            for (char ch = 'a'; ch <= 'z'; ch++) {

                boolean possible = false;

                // Try matching inserted character with s2[j]
                for (int j = 0; j < m; j++) {

                    if (s2.charAt(j) == ch) {

                        int left = pref[pos][j];
                        int right = suff[pos][j + 1];

                        if (left + 1 + right == original + 1) {
                            possible = true;
                            break;
                        }
                    }
                }

                if (possible) {
                    answer++;
                }
            }
        }

        return answer;
    }
}