class Solution {
    int majorityElement(int[] arr) {
        int candidate = -1;
        int count = 0;

        // Phase 1: Find a potential majority candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify if the candidate appears > arr.length / 2 times
        int actualCount = 0;
        for (int num : arr) {
            if (num == candidate) {
                actualCount++;
            }
        }

        // Return candidate if strictly greater than N / 2, else return -1
        if (actualCount > arr.length / 2) {
            return candidate;
        }

        return -1;
    }
}