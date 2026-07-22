class Solution {
    static int search(int arr[], int x) {
        // Iterate through the array to find the first occurrence of x
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i; // Return 0-based index immediately when found
            }
        }
        
        // Element not present in the array
        return -1;
    }
}