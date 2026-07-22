import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        int left = 0;
        int right = arr.length - 1;

        // Step 2: Two-pointer technique
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == 0) {
                // Found a valid zero-sum pair
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                result.add(pair);

                int leftVal = arr[left];
                int rightVal = arr[right];

                // Skip duplicate elements on the left side
                while (left < right && arr[left] == leftVal) {
                    left++;
                }

                // Skip duplicate elements on the right side
                while (left < right && arr[right] == rightVal) {
                    right--;
                }
            } else if (sum < 0) {
                left++;  // Sum is too small, need a larger value
            } else {
                right--; // Sum is too large, need a smaller value
            }
        }

        return result;
    }
}