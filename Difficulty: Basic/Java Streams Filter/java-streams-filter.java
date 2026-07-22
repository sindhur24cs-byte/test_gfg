import java.util.Arrays;

class Solution {
    public static int filterUsingStreams(int[] arr) {
        // Step 1: Convert the array into an IntStream
        // Step 2: Filter elements to retain only odd numbers (x % 2 != 0)
        // Step 3: Find the maximum value
        // Step 4: Return value or -1 if no odd element exists
        return Arrays.stream(arr)
                     .filter(x -> x % 2 != 0)
                     .max()
                     .orElse(-1);
    }
}