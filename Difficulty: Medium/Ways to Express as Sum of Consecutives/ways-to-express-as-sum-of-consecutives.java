class Solution {
    public int getCount(int n) {
        int count = 0;

        for (int len = 2; len * (len + 1) / 2 <= n; len++) {
            int value = n - len * (len - 1) / 2;

            if (value > 0 && value % len == 0)
                count++;
        }

        return count;
    }
}