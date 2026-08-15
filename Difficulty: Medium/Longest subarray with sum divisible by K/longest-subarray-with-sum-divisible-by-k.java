class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        int[] first = new int[k];

        java.util.Arrays.fill(first, -2);

        long sum = 0;
        int ans = 0;

        // Remainder 0 occurs before the array starts
        first[0] = -1;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            int rem = (int)(sum % k);

            if (rem < 0) {
                rem += k;
            }

            if (first[rem] != -2) {
                ans = Math.max(ans, i - first[rem]);
            } else {
                // Store only the first occurrence
                first[rem] = i;
            }
        }

        return ans;
    }
}