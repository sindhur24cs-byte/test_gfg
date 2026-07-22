class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;

        // Base case: If the first element is 0, we can't move anywhere
        if (arr[0] == 0) {
            return -1;
        }

        int jumps = 1;         // Number of jumps taken
        int maxReach = arr[0]; // Furthest index reachable in current/next jump
        int steps = arr[0];    // Steps remaining within the current jump

        for (int i = 1; i < n; i++) {
            // Check if we've reached the last index
            if (i == n - 1) {
                return jumps;
            }

            // Continually update the furthest point reachable from index i
            maxReach = Math.max(maxReach, i + arr[i]);

            // Consume a step to move to index i
            steps--;

            // If no steps left in current jump interval
            if (steps == 0) {
                jumps++; // Must take another jump

                // If current index is beyond or equal to maxReach, we can't progress further
                if (i >= maxReach) {
                    return -1;
                }

                // Re-initialize steps available for the new jump
                steps = maxReach - i;
            }
        }

        return -1;
    }
}