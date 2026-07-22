import java.util.Arrays;

class Solution {
    // Function to find the minimum number of platforms required
    public int minPlatform(int[] arr, int[] dep) {
        int n = arr.length;

        // Step 1: Sort both arrival and departure arrays independently
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Step 2: Two pointers to traverse arrival and departure arrays
        int i = 0; // Pointer for arrival
        int j = 0; // Pointer for departure

        int platformsNeeded = 0;
        int maxPlatforms = 0;

        // Step 3: Sweep line process
        while (i < n && j < n) {
            // If next event is an arrival
            if (arr[i] <= dep[j]) {
                platformsNeeded++;
                maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
                i++;
            } 
            // If next event is a departure
            else {
                platformsNeeded--;
                j++;
            }
        }

        return maxPlatforms;
    }
}