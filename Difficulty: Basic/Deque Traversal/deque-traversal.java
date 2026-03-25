import java.util.*;

class Solution {
    public void printDeque(Deque<Integer> dq) {
        for (int num : dq) {
            System.out.print(num + " ");
        }
        System.out.println(); // newline at end
    }
}