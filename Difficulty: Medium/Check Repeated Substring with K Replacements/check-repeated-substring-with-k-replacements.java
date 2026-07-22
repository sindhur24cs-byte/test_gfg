import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean kSubstr(String s, int k) {
        int n = s.length();
        
        if (n % k != 0) {
            return false;
        }

        Map<String, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < n; i += k) {
            String sub = s.substring(i, i + k);
            freqMap.put(sub, freqMap.getOrDefault(sub, 0) + 1);
        }

        if (freqMap.size() == 1) {
            return true;
        }

        if (freqMap.size() == 2) {
            int totalBlocks = n / k;
            
            if (totalBlocks == 2) {
                return true;
            }

            for (int count : freqMap.values()) {
                if (count == 1) {
                    return true;
                }
            }
        }

        return false;
    }
}