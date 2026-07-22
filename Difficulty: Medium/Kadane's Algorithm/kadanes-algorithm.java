class Solution {
    int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Decide whether to add current element to existing subarray or start fresh
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            
            // Keep track of the overall maximum sum seen so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}