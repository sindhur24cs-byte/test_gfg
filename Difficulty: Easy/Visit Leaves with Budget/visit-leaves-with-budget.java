class Solution {
    public int getCount(Node root, int k) {
        ArrayList<Integer> a = new ArrayList<>();
        dfs(root, 1, a);

        Collections.sort(a);

        int count = 0;

        for (int x : a) {
            if (k >= x) {
                k -= x;
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    void dfs(Node root, int level, ArrayList<Integer> a) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            a.add(level);
            return;
        }

        dfs(root.left, level + 1, a);
        dfs(root.right, level + 1, a);
    }
}