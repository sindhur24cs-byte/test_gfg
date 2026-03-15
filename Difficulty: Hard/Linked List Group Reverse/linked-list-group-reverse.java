class Solution {
    public Node reverseKGroup(Node head, int k) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;

        // reverse first k nodes
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // reverse remaining nodes
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}