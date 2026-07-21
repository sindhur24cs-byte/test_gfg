import java.util.*;

class Solution {

    void eraseAt(Deque<Integer> deq, int x) {
        Iterator<Integer> it = deq.iterator();

        for (int i = 0; i < x; i++) {
            it.next();
        }

        it.next();
        it.remove();
    }

    void eraseInRange(Deque<Integer> deq, int start, int end) {
        Iterator<Integer> it = deq.iterator();

        for (int i = 0; i < start; i++) {
            it.next();
        }

        for (int i = start; i < end; i++) {
            it.next();
            it.remove();
        }
    }

    void eraseAll(Deque<Integer> deq) {
        deq.clear();
    }
}