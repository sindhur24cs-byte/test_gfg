class Solution {

    public static ArrayList<ArrayList<Integer>> paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        dfs(root, path, ans);

        return ans;
    }

    static void dfs(Node node, ArrayList<Integer> path,
                    ArrayList<ArrayList<Integer>> ans) {

        if (node == null)
            return;

        path.add(node.data);

        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(node.left, path, ans);
            dfs(node.right, path, ans);
        }

        path.remove(path.size() - 1);
    }
}