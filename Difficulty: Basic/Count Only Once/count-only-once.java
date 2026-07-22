import java.util.HashSet;

class Solution {
    // Function to count unique elements in the array
    public static int countOnce(int arr[]) {
        // Step 1: Insert all elements into a HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // Step 2: Return the size of the set (unique count)
        return set.size();
    }
}