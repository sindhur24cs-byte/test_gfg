class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        int noTask = 0;
        int low = 0;
        int high = 0;

        for (int i = 0; i < n; i++) {
            int newHigh = noTask + h[i];
            int newLow = Math.max(noTask, Math.max(low, high)) + l[i];
            int newNoTask = Math.max(noTask, Math.max(low, high));

            high = newHigh;
            low = newLow;
            noTask = newNoTask;
        }

        return Math.max(noTask, Math.max(low, high));
    }
}