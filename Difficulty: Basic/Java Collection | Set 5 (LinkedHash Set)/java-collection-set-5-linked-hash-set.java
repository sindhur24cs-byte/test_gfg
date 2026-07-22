import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

class GfG {
    // 1. Insert element x into set
    void insert(LinkedHashSet<Integer> s, int x) {
        s.add(x);
    }

    // 2. Print contents in increasing (sorted) order
    void print_Contents_Increasing_Order(LinkedHashSet<Integer> s) {
        ArrayList<Integer> list = new ArrayList<>(s);
        Collections.sort(list);
        for (int x : list) {
            System.out.print(x + " ");
        }
    }

    // 3. Erase element x from set
    void erase(LinkedHashSet<Integer> s, int x) {
        s.remove(x);
    }

    // 4. Return 1 if element x is present, else return -1
    int find(LinkedHashSet<Integer> s, int x) {
        return s.contains(x) ? 1 : -1;
    }

    // 5. Return size of the LinkedHashSet
    int size(LinkedHashSet<Integer> s) {
        return s.size();
    }

    // 6. Print contents in insertion order
    void print_Contents_Insertion_Order(LinkedHashSet<Integer> s) {
        for (int x : s) {
            System.out.print(x + " ");
        }
    }
}