class Solution {
    int minSteps(int[] arr, int start, int end) {
        if (start == end) return 0;

        int[] dist = new int[1000];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int num : arr) {
                int next = (curr * num) % 1000;

                if (dist[next] > dist[curr] + 1) {
                    dist[next] = dist[curr] + 1;

                    if (next == end) {
                        return dist[next];
                    }

                    q.offer(next);
                }
            }
        }

        return -1;
    }
}