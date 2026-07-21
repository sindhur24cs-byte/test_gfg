import java.util.*;

class Solution {

    public void add_to_ArrayList(ArrayList<Integer> A, int x) {
        A.add(x);
    }

    public void sort_ArrayList_Asc(ArrayList<Integer> A) {
        Collections.sort(A);
    }

    public void reverse_ArrayList(ArrayList<Integer> A) {
        Collections.reverse(A);
    }

    public int size_Of_ArrayList(ArrayList<Integer> A) {
        return A.size();
    }

    public void sort_ArrayList_Desc(ArrayList<Integer> A) {
        Collections.sort(A, Collections.reverseOrder());
    }

    public void print_ArrayList(ArrayList<Integer> A) {
        for (int x : A) {
            System.out.print(x + " ");
        }
    }
}