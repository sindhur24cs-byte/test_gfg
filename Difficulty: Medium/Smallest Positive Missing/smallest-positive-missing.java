class Solution {
    public int missingNumber(int[] arr) {

        int n = arr.length;
        boolean hasOne = false;

        // Check if 1 exists and replace invalid numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                hasOne = true;
            }

            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = 1;
            }
        }

        // If 1 is not present, answer is 1
        if (!hasOne) {
            return 1;
        }

        // Mark existing numbers
        for (int i = 0; i < n; i++) {

            int value = Math.abs(arr[i]);

            if (value <= n) {
                arr[value - 1] = -Math.abs(arr[value - 1]);
            }
        }

        // Find first positive index
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}