class Solution {
    public int splitArray(int[] arr, int k) {
        int low = 0;
        int high = 0;

        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            int sum = 0;
            int parts = 1;

            for (int i = 0; i < arr.length; i++) {
                if (sum + arr[i] <= mid) {
                    sum = sum + arr[i];
                } else {
                    parts++;
                    sum = arr[i];
                }
            }

            if (parts <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
