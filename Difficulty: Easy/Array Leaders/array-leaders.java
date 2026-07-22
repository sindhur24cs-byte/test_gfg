import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        // The rightmost element is always a leader
        int maxFromRight = arr[n - 1];
        result.add(maxFromRight);

        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            // An element is a leader if it is >= all elements to its right
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                result.add(maxFromRight);
            }
        }

        // Reverse to maintain the original left-to-right order
        Collections.reverse(result);

        return result;
    }
}