import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Map to store (prefixSum, firstOccurredIndex)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: Subarray starting from index 0 has sum equal to k
            if (prefixSum == k) {
                maxLength = i + 1;
            }

            // Case 2: Subarray between some previous index and current index i has sum k
            // If (prefixSum - k) exists in map, then sum of elements between map.get(prefixSum - k) + 1 and i is k
            if (map.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum - k));
            }

            // Store prefixSum in map only if it doesn't exist yet
            // (We want the earliest occurrence to maximize the subarray length)
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}