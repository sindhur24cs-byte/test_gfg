class Solution {
    public int findExtra(int[] a, int[] b) {
        int low = 0;
        int high = b.length - 1;
        int ans = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] == b[mid]) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }
}