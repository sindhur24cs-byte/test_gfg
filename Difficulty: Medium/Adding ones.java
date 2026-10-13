
import java.util.*;

class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        int[] arr = new int[n];

        for (int i = 0; i < updates.length; i++) {
            arr[updates[i] - 1]++;
        }

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
