import java.util.Collections;
import java.util.List;

class Solution {
    // Function to calculate maximum total value the thief can pick
    public static int getMaxVal(List<Integer> arr, int k) {
        // Step 1: Sort the list in ascending order
        Collections.sort(arr);

        int sum = 0;
        int n = arr.size();

        // Step 2: Sum the largest 'k' elements from the end
        for (int i = n - 1; i >= n - k; i--) {
            sum += arr.get(i);
        }

        return sum;
    }
}