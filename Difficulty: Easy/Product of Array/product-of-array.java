class Solution {
    public long product(long[] arr) {
        long mod = 1000000007;
        long result = 1;

        for (long num : arr) {
            result = (result * num) % mod;
        }

        return result;
    }
}