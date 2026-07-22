import java.util.Map;
import java.util.TreeMap;

class Solution {
    public void freqSorted(int[] arr) {
        // Step 1: Use TreeMap to count frequencies while keeping keys automatically sorted
        Map<Integer, Integer> freqMap = new TreeMap<>();
        
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Print key and frequency line-by-line
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}