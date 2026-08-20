class Solution {
    int ans = Integer.MIN_VALUE;

    void dfs(Node root, int maxAncestor) {
        if (root == null) {
            return;
        }

        // Compare current node with a STRICT ancestor
        ans = Math.max(ans, maxAncestor - root.data);

        // Update ancestor only after comparison
        int newMaxAncestor = Math.max(maxAncestor, root.data);

        dfs(root.left, newMaxAncestor);
        dfs(root.right, newMaxAncestor);
    }

    int maxDiff(Node root) {
        // Start from the children, so root is never compared with itself
        if (root.left != null) {
            dfs(root.left, root.data);
        }

        if (root.right != null) {
            dfs(root.right, root.data);
        }

        return ans;
    }
}