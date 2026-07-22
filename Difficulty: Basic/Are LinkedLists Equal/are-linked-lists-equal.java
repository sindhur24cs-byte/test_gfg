import java.util.LinkedList;

class Solution {
    public static boolean areEqual(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        // Java's built-in equals() method checks if both LinkedLists 
        // have the exact same size and elements in the exact same order.
        return ll1.equals(ll2);
    }
}