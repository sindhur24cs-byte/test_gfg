class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;

        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];

        int max = arr[0];
        int min = arr[0];

        leftMax[0] = max;
        leftMin[0] = min;

        for (int i = 1; i < n; i++) {
            max = Math.max(arr[i], max + arr[i]);
            min = Math.min(arr[i], min + arr[i]);

            leftMax[i] = Math.max(leftMax[i - 1], max);
            leftMin[i] = Math.min(leftMin[i - 1], min);
        }

        max = arr[n - 1];
        min = arr[n - 1];

        rightMax[n - 1] = max;
        rightMin[n - 1] = min;

        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(arr[i], max + arr[i]);
            min = Math.min(arr[i], min + arr[i]);

            rightMax[i] = Math.max(rightMax[i + 1], max);
            rightMin[i] = Math.min(rightMin[i + 1], min);
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans,
                    Math.abs(leftMax[i] - rightMin[i + 1]));

            ans = Math.max(ans,
                    Math.abs(leftMin[i] - rightMax[i + 1]));
        }

        return ans;
    }
}