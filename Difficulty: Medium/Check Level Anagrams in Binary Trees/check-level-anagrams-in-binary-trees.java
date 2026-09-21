class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int n1 = q1.size();
            int n2 = q2.size();

            if (n1 != n2)
                return false;

            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();

            for (int i = 0; i < n1; i++) {
                Node x = q1.poll();
                Node y = q2.poll();

                a.add(x.data);
                b.add(y.data);

                if (x.left != null)
                    q1.add(x.left);
                if (x.right != null)
                    q1.add(x.right);

                if (y.left != null)
                    q2.add(y.left);
                if (y.right != null)
                    q2.add(y.right);
            }

            Collections.sort(a);
            Collections.sort(b);

            if (!a.equals(b))
                return false;
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}