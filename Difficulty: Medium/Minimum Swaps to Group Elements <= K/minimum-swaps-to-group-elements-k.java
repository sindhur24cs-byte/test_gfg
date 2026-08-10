class Solution {
    public int minSwap(int[] arr, int k) {
        int good = 0;

        // Count elements <= k
        for (int x : arr) {
            if (x <= k)
                good++;
        }

        if (good <= 1)
            return 0;

        int bad = 0;

        // First window
        for (int i = 0; i < good; i++) {
            if (arr[i] > k)
                bad++;
        }

        int ans = bad;

        // Slide the window
        for (int i = good; i < arr.length; i++) {
            if (arr[i] > k)
                bad++;

            if (arr[i - good] > k)
                bad--;

            ans = Math.min(ans, bad);
        }

        return ans;
    }
}