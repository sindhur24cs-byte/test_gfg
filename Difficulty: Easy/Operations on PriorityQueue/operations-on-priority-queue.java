import java.util.PriorityQueue;

class Geeks {

    // Function to insert element into the queue
    static void insert(PriorityQueue<Integer> q, int k) {
        q.add(k);
    }

    // Function to find an element k in the queue
    static boolean find(PriorityQueue<Integer> q, int k) {
        return q.contains(k);
    }

    // Function to delete the max element from the queue
    static int delete(PriorityQueue<Integer> q) {
        if (!q.isEmpty()) {
            return q.poll();
        }
        return -1;
    }

    // Function to return the max element from the queue
    static int getHead(PriorityQueue<Integer> q) {
        if (!q.isEmpty()) {
            return q.peek();
        }
        return -1;
    }
}