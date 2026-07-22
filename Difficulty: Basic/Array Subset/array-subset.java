import java.util.HashMap;

class Solution {
    public boolean isSubset(int a[], int b[]) {
        // Step 1: Count frequencies of all elements in array 'a'
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Verify if array 'b' elements exist with sufficient frequency
        for (int num : b) {
            int count = freqMap.getOrDefault(num, 0);
            
            if (count == 0) {
                return false; // Element missing or frequency exhausted
            }
            
            freqMap.put(num, count - 1);
        }

        return true; // All elements of 'b' were matched
    }
}