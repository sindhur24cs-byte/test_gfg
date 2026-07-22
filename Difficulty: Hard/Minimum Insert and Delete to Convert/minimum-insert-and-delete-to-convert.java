import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            map.put(b[i], i);
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int x : a) {
            if (map.containsKey(x)) {
                int index = map.get(x);

                int pos = Collections.binarySearch(lis, index);

                if (pos < 0) {
                    pos = -pos - 1;
                }

                if (pos == lis.size()) {
                    lis.add(index);
                } else {
                    lis.set(pos, index);
                }
            }
        }

        int common = lis.size();

        return n + m - 2 * common;
    }
}