import java.util.*;

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Store distinct elements
        ArrayList<Integer> list = new ArrayList<>(freq.keySet());

        // Sort by frequency descending
        // If frequency is same, larger number first
        Collections.sort(list, (a, b) -> {
            if (freq.get(a) != freq.get(b)) {
                return freq.get(b) - freq.get(a);
            }
            return b - a;
        });

        // Take top k
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ans.add(list.get(i));
        }

        return ans;
    }
}