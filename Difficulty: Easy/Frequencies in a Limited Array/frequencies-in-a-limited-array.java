import java.util.*;

class Solution {
    public ArrayList<Integer> frequencyCount(int arr[]) {
        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        // Count frequencies
        int freq[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        // Store answer for numbers 1 to n
        for (int i = 1; i <= n; i++) {
            result.add(freq[i]);
        }

        return result;
    }
}