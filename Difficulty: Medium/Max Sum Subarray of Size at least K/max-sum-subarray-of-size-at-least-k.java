class Solution {
    public int maxSumWithK(int a[], int k) {
        int n = a.length;

        // 1. Calculate sum of first window of size k
        int currentKSum = 0;
        for (int i = 0; i < k; i++) {
            currentKSum += a[i];
        }

        int maxSum = currentKSum;
        int leftSum = 0;

        // 2. Slide window across the array
        for (int i = k; i < n; i++) {
            leftSum += a[i - k];

            // Drop negative left tail
            if (leftSum < 0) {
                leftSum = 0;
            }

            // Update sliding window sum
            currentKSum += a[i] - a[i - k];

            // Compare maximum sum
            maxSum = Math.max(maxSum, currentKSum + leftSum);
        }

        return maxSum;
    }
}