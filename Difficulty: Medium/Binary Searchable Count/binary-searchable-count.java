public class Solution {
    public int binarySearchable(int[] arr) {
        return helper(arr, 0, arr.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int helper(int[] arr, int l, int r, int maxLeft, int minRight) {
        if (l > r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        int count = 0;

        if (arr[mid] > maxLeft && arr[mid] < minRight) {
            count = 1;
        }

        int leftCount = helper(arr, l, mid - 1, maxLeft, Math.min(minRight, arr[mid]));
        int rightCount = helper(arr, mid + 1, r, Math.max(maxLeft, arr[mid]), minRight);

        return count + leftCount + rightCount;
    }
}