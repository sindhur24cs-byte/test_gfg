import java.util.Arrays;

class Solution {
    public double avgUsingStreams(int[] arr) {
        // Step 1: Convert primitive array to IntStream
        // Step 2: Use .average() to get OptionalDouble
        // Step 3: Extract value with .orElse(0.0)
        return Arrays.stream(arr)
                     .average()
                     .orElse(0.0);
    }
}