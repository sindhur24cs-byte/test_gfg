class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        int[] dist = new int[V];

        // Run Bellman-Ford for V iterations
        for (int i = 0; i < V; i++) {
            boolean updated = false;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    updated = true;

                    // If relaxation happens on V-th iteration,
                    // a negative weight cycle exists.
                    if (i == V - 1) {
                        return true;
                    }
                }
            }

            // No relaxation means no negative cycle
            if (!updated) {
                break;
            }
        }

        return false;
    }
}