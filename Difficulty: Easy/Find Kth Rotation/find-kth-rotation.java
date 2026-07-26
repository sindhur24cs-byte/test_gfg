class Solution {
    public int findKRotation(int arr[]) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Minimum is in the right half
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            }
            // Minimum is in the left half including mid
            else {
                high = mid;
            }
        }

        return low;
    }
}