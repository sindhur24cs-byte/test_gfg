import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];

            if (!map.containsKey(x)) {
                result.add(0);
                continue;
            }

            List<Integer> indices = map.get(x);

            int leftIdx = lowerBound(indices, l);
            int rightIdx = upperBound(indices, r);

            result.add(rightIdx - leftIdx);
        }

        return result;
    }

    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int upperBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}