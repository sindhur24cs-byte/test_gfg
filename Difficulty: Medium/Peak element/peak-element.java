class Solution {
    public int peakElement(int[] arr) {
        int n = arr.length;
        
        // Base case: Single element is always a peak
        if (n == 1) return 0;
        
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is greater than its left neighbor (if left exists)
            boolean leftSmaller = (mid == 0) || (arr[mid] > arr[mid - 1]);
            
            // Check if mid is greater than its right neighbor (if right exists)
            boolean rightSmaller = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            // If mid is greater than both neighbors, it's a peak
            if (leftSmaller && rightSmaller) {
                return mid;
            }

            // If the right neighbor is larger, a peak MUST exist on the right side
            if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } 
            // Otherwise, a peak MUST exist on the left side
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}