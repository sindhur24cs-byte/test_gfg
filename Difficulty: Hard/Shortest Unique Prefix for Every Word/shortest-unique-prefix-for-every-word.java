class Solution {
    class Node {
        Node[] child = new Node[26];
        int count;
    }

    Node root = new Node();

    void insert(String s) {
        Node curr = root;

        for (char c : s.toCharArray()) {
            int index = c - 'a';

            if (curr.child[index] == null)
                curr.child[index] = new Node();

            curr = curr.child[index];
            curr.count++;
        }
    }

    String findPrefix(String s) {
        Node curr = root;
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            ans.append(c);
            curr = curr.child[index];

            if (curr.count == 1)
                break;
        }

        return ans.toString();
    }

    public ArrayList<String> findPrefixes(String[] arr) {
        for (String s : arr)
            insert(s);

        ArrayList<String> result = new ArrayList<>();

        for (String s : arr)
            result.add(findPrefix(s));

        return result;
    }
}