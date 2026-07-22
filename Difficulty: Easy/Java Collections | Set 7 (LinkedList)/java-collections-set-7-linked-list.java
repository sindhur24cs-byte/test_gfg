/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class GfG {
    // Function to delete the given node without head pointer
    public void deleteNode(Node node) {
        if (node == null || node.next == null) {
            return;
        }

        // Step 1: Copy the data from the next node into the current node
        node.data = node.next.data;

        // Step 2: Skip the next node by relinking pointers
        node.next = node.next.next;
    }
}