class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        
        // Handle cases where d >= n
        d = d % n;
        if (d == 0) return;

        // Step 1: Reverse first d elements [0 to d-1]
        reverse(arr, 0, d - 1);

        // Step 2: Reverse remaining elements [d to n-1]
        reverse(arr, d, n - 1);

        // Step 3: Reverse the whole array [0 to n-1]
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}