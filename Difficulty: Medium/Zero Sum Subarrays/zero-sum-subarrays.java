import java.util.*;

class Solution {
    public long findSubarray(int[] arr) {
        HashMap<Long, Long> map = new HashMap<>();

        long prefixSum = 0;
        long count = 0;

        // Empty prefix
        map.put(0L, 1L);

        for (int num : arr) {
            prefixSum += num;

            // If this prefix sum appeared before,
            // all those positions form zero-sum subarrays
            if (map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0L) + 1);
        }

        return count;
    }
}