class Solution {
    public int maxIndexDiff(int arr[]) {
        int n = arr.length;

        int leftMin[] = new int[n];
        int rightMax[] = new int[n];

        // Store minimum value from left side
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(arr[i], leftMin[i - 1]);
        }

        // Store maximum value from right side
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }

        int i = 0, j = 0;
        int maxDiff = 0;

        // Find maximum j - i
        while (i < n && j < n) {
            if (leftMin[i] <= rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }
}