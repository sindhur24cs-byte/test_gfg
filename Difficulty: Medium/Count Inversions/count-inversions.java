class Solution {
    // Function to count inversions in the array
    static int inversionCount(int arr[]) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in left subarray
            count += mergeSortAndCount(arr, left, mid);

            // Count inversions in right subarray
            count += mergeSortAndCount(arr, mid + 1, right);

            // Count cross inversions during merge step
            count += mergeAndCount(arr, left, mid, right);
        }

        return count;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        int swaps = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                // Key step: If leftArr[i] > rightArr[j], then all remaining 
                // elements in leftArr from index i to end will also be > rightArr[j]
                swaps += (leftArr.length - i);
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return swaps;
    }
}