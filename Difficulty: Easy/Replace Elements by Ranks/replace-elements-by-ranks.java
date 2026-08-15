class Solution {
    public void replaceWithRank(int[] arr) {
        int n = arr.length;

        int[][] temp = new int[n][2];

        // Store value and original index
        for (int i = 0; i < n; i++) {
            temp[i][0] = arr[i];
            temp[i][1] = i;
        }

        // Sort by value, then by original index
        java.util.Arrays.sort(temp, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Assign ranks
        for (int rank = 0; rank < n; rank++) {
            int index = temp[rank][1];
            arr[index] = rank;
        }
    }
}