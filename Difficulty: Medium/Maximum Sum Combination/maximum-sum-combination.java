import java.util.*;

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;

        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> Integer.compare(y[0], x[0])
        );

        HashSet<String> visited = new HashSet<>();

        // Start with the largest elements
        pq.offer(new int[]{a[n - 1] + b[n - 1], n - 1, n - 1});
        visited.add((n - 1) + "," + (n - 1));

        ArrayList<Integer> result = new ArrayList<>();

        while (result.size() < k && !pq.isEmpty()) {
            int[] curr = pq.poll();

            int sum = curr[0];
            int i = curr[1];
            int j = curr[2];

            result.add(sum);

            // Move in a
            if (i - 1 >= 0) {
                String key = (i - 1) + "," + j;

                if (!visited.contains(key)) {
                    pq.offer(new int[]{
                        a[i - 1] + b[j], i - 1, j
                    });
                    visited.add(key);
                }
            }

            // Move in b
            if (j - 1 >= 0) {
                String key = i + "," + (j - 1);

                if (!visited.contains(key)) {
                    pq.offer(new int[]{
                        a[i] + b[j - 1], i, j - 1
                    });
                    visited.add(key);
                }
            }
        }

        return result;
    }
}