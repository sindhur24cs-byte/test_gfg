class Solution {
    public int countStrings(int n) {
        if (n == 1) return 2;
        if (n == 2) return 3;

        int a = 2; // n = 1
        int b = 3; // n = 2

        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}