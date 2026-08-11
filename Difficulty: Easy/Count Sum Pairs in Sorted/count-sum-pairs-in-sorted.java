class Solution {
    public int countPairs(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        long count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                // Same values on both sides
                if (arr[left] == arr[right]) {
                    long n = right - left + 1;
                    count += n * (n - 1) / 2;
                    break;
                }

                // Count duplicates of left value
                long leftCount = 1;
                while (left + leftCount < right &&
                       arr[left + (int)leftCount] == arr[left]) {
                    leftCount++;
                }

                // Count duplicates of right value
                long rightCount = 1;
                while (right - rightCount > left &&
                       arr[right - (int)rightCount] == arr[right]) {
                    rightCount++;
                }

                count += leftCount * rightCount;

                left += (int)leftCount;
                right -= (int)rightCount;
            }
        }

        return (int) count;
    }
}