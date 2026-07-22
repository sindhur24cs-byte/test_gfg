import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Get the value (taking absolute value since it might be negated already)
            int val = Math.abs(arr[i]);
            int index = val - 1;

            // If the element at index is negative, val has been seen before
            if (arr[index] < 0) {
                result.add(val);
            } else {
                // Mark as seen by negating
                arr[index] = -arr[index];
            }
        }

        return result;
    }
}