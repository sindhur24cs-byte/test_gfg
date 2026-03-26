import java.util.*;

class Solution {
    public ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int sum = 0;

        for (int end = 0; end < n; end++) {
            sum += arr[end];

            while (sum > target && start <= end) {
                sum -= arr[start];
                start++;
            }

            if (sum == target) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(start + 1); // 1-based index
                res.add(end + 1);
                return res;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        return res;
    }
}