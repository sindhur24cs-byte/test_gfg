import java.util.Arrays;

class Solution {
    public int maxValue(int arr[]) {
        int n = arr.length;
        long mod = 1000000007;

        Arrays.sort(arr);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * i) % mod;
        }

        return (int) ans;
    }
}