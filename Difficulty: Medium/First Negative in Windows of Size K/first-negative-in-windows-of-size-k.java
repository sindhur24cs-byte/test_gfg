class Solution {
    public List<Integer> firstNegInt(int[] arr, int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                q.offer(i);

            if (i >= k - 1) {
                while (!q.isEmpty() && q.peek() <= i - k)
                    q.poll();

                if (q.isEmpty())
                    ans.add(0);
                else
                    ans.add(arr[q.peek()]);
            }
        }

        return ans;
    }
}