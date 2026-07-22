import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static ArrayList<Integer> uniqueSorted(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        ArrayList<Integer> result = new ArrayList<>();
        if (arr.length == 0) return result;

        // Step 2: Traverse and collect only distinct elements
        result.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }

        return result;
    }
}