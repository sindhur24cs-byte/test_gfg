class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        int far = bfs(0, adj, n);
        int diameter = bfsDistance(far, adj, n);

        return (diameter + 1) / 2;
    }

    int bfs(int start, ArrayList<ArrayList<Integer>> adj, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        int far = start;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                v--;

                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);

                    if (dist[v] > dist[far]) {
                        far = v;
                    }
                }
            }
        }

        return far;
    }

    int bfsDistance(int start, ArrayList<ArrayList<Integer>> adj, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        int max = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                v--;

                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    max = Math.max(max, dist[v]);
                    q.add(v);
                }
            }
        }

        return max;
    }
}