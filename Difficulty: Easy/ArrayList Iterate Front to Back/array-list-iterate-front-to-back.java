import java.util.Iterator;

class Solution {
    public static void iterateArrayList(Iterator<Integer> it) {
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}