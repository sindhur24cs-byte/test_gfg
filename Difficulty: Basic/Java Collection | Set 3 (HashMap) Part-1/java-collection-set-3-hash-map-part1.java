import java.util.HashMap;

class Solution {
    static int map(int n, String keys[], int arr[], String s) {
        // Step 1: Create a HashMap to store key-value pairs
        HashMap<String, Integer> map = new HashMap<>();

        // Step 2: Populate the HashMap with key[i] -> arr[i]
        for (int i = 0; i < n; i++) {
            map.put(keys[i], arr[i]);
        }

        // Step 3: Check if key 's' exists and return its value, else return -1
        return map.getOrDefault(s, -1);
    }
}