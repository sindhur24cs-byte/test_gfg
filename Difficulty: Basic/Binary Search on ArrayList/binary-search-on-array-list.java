import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int binarySearchAL(ArrayList<Integer> list, int k) {
        // Step 1: Perform binary search on sorted ArrayList
        int index = Collections.binarySearch(list, k);

        // Step 2: Return index if found, else -1
        return index >= 0 ? index : -1;
    }
}