class Solution {
    public int transform(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }

        int n = s1.length();

        // Check if both strings contain the same characters
        int[] freq = new int[256];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int x : freq) {
            if (x != 0) {
                return -1;
            }
        }

        // Compare from the end
        int i = n - 1;
        int j = n - 1;
        int steps = 0;

        while (i >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
            } else {
                // Move this character to the front
                i--;
                steps++;
            }
        }

        return steps;
    }
}