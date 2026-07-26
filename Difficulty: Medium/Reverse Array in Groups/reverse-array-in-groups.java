class Solution {
    public void reverseInGroups(int arr[], int k) {
        int n = arr.length;

        for (int start = 0; start < n; start += k) {
            int left = start;
            int right = Math.min(start + k - 1, n - 1);

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }
}