class Solution {

    // Finds the Lowest Common Ancestor (LCA) of nodes p and q
    private static Node findLCA(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }

    // Counts turns from root/LCA to the target node
    private static boolean countTurns(Node node, int target, boolean isLeft, int[] turns) {
        if (node == null) return false;
        if (node.data == target) return true;

        if (isLeft) {
            if (countTurns(node.left, target, true, turns)) return true;
            if (countTurns(node.right, target, false, turns)) {
                turns[0]++;
                return true;
            }
        } else {
            if (countTurns(node.right, target, false, turns)) return true;
            if (countTurns(node.left, target, true, turns)) {
                turns[0]++;
                return true;
            }
        }
        return false;
    }

    // Renamed method to match driver code expected signature
    public static int numberOfTurns(Node root, int p, int q) {
        Node lca = findLCA(root, p, q);

        // Case 1: p and q are on different subtrees of LCA
        if (lca.data != p && lca.data != q) {
            int[] turnsP = new int[]{0};
            int[] turnsQ = new int[]{0};

            boolean foundP = countTurns(lca.left, p, true, turnsP);
            if (!foundP) countTurns(lca.right, p, false, turnsP);

            boolean foundQ = countTurns(lca.left, q, true, turnsQ);
            if (!foundQ) countTurns(lca.right, q, false, turnsQ);

            return turnsP[0] + turnsQ[0] + 1;
        }

        // Case 2: One node is an ancestor of the other
        int target = (lca.data == p) ? q : p;
        int[] turns = new int[]{0};

        boolean found = countTurns(lca.left, target, true, turns);
        if (!found) countTurns(lca.right, target, false, turns);

        return (turns[0] == 0) ? -1 : turns[0];
    }
}