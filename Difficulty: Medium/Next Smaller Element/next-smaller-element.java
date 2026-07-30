class Solution {
    ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        for (int x : res) {
            ans.add(x);
        }

        return ans;
    }
}