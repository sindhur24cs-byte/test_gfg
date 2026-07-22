class Solution {
    public static int largest(int[] arr) {
        // Initialize max with the first element
        int max = arr[0];

        // Traverse the array to find the largest element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}