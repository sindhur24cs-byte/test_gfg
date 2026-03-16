import java.util.*;

class Solution {

    // push back
    static void pb(ArrayDeque<Integer> dq, int x) {
        dq.addLast(x);
    }

    // push front
    static void pf(ArrayDeque<Integer> dq, int x) {
        dq.addFirst(x);
    }

    // pop back
    static void ppb(ArrayDeque<Integer> dq) {
        if (!dq.isEmpty()) {
            dq.removeLast();
        }
    }

    // return front element
    static int front_dq(ArrayDeque<Integer> dq) {
        if (dq.isEmpty())
            return -1;
        return dq.peekFirst();
    }
}