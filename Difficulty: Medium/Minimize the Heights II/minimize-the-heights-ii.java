import java.util.Arrays;

class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0;

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Initial difference without any modifications
        int ans = arr[n - 1] - arr[0];

        // Potential minimum and maximum heights after operation
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        // Step 2: Iterate through adjacent elements to find minimum possible difference
        for (int i = 0; i < n - 1; i++) {
            // Heights cannot be negative after operation
            if (arr[i + 1] - k < 0) {
                continue;
            }

            int minVal = Math.min(smallest, arr[i + 1] - k);
            int maxVal = Math.max(largest, arr[i] + k);

            ans = Math.min(ans, maxVal - minVal);
        }

        return ans;
    }
}