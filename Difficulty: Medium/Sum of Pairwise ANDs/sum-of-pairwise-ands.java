class Solution {
    public long pairAndSum(int[] arr) {
        long ans = 0;

        for (int bit = 0; bit < 31; bit++) {
            long count = 0;

            // Count elements having this bit set
            for (int x : arr) {
                if ((x & (1 << bit)) != 0) {
                    count++;
                }
            }

            // Number of pairs having this bit set in AND
            long pairs = count * (count - 1) / 2;

            // Contribution of this bit
            ans += pairs * (1L << bit);
        }

        return ans;
    }
}