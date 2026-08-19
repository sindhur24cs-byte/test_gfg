import java.util.*;

class Solution {

    // Counts triplets with sum <= x
    private long countLessEqual(int[] arr, long x) {
        int n = arr.length;
        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];

                if (sum <= x) {
                    // All elements from left to right form valid triplets
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }

    public long countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);

        return countLessEqual(arr, r) - countLessEqual(arr, (long) l - 1);
    }
}