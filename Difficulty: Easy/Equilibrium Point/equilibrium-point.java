class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int totalSum = 0;

        // Step 1: Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        // Step 2: Iterate through the array and check for equilibrium point
        for (int i = 0; i < arr.length; i++) {
            // Right sum is totalSum - leftSum - arr[i]
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i; // Found the first 0-based equilibrium index
            }

            leftSum += arr[i];
        }

        return -1; // No equilibrium point found
    }
}