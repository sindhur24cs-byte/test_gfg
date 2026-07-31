class Solution {
    static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int minSwaps(int[] arr) {
        int n = arr.length;

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        Arrays.sort(pairs, (a, b) -> a.value - b.value);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i] || pairs[i].index == i)
                continue;

            int cycle = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j].index;
                cycle++;
            }

            if (cycle > 1)
                swaps += cycle - 1;
        }

        return swaps;
    }
}