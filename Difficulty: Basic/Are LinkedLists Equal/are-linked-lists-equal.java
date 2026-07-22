import java.util.LinkedList;

class Solution {
    // Function to check if two LinkedLists are equal
    public static boolean areEqual(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        // Built-in .equals() checks if both lists have the same elements in the exact same order
        return ll1.equals(ll2);
    }
}