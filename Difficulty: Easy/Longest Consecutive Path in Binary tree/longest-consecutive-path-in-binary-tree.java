class Solution {

    int maxLen = 1;

    public int longestConsecutive(Node root) {

        if (root == null)
            return -1;

        dfs(root, 1);

        return maxLen == 1 ? -1 : maxLen;
    }

    void dfs(Node node, int len) {

        if (node == null)
            return;

        maxLen = Math.max(maxLen, len);

        if (node.left != null) {
            if (node.left.data == node.data + 1)
                dfs(node.left, len + 1);
            else
                dfs(node.left, 1);
        }

        if (node.right != null) {
            if (node.right.data == node.data + 1)
                dfs(node.right, len + 1);
            else
                dfs(node.right, 1);
        }
    }
}