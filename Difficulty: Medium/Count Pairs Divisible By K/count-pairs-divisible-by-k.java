class Solution {
    public int countKdivPairs(int[] arr, int k) {
        long[] freq = new long[k];
        long ans = 0;

        for (int num : arr) {
            int rem = num % k;
            int need = (k - rem) % k;

            ans += freq[need];
            freq[rem]++;
        }

        return (int) ans;
    }
}