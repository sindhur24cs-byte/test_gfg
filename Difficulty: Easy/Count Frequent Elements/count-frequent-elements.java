import java.util.*;

class Solution {
    public int countOccurence(int[] arr, int k) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int freq : map.values()) {
            if (freq > n / k) {
                count++;
            }
        }

        return count;
    }
}