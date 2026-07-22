import java.util.TreeSet;

class Solution {
    // Function to insert elements of array into TreeSet and return it
    public static TreeSet<Integer> insert(int arr[]) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set;
    }

    // Function to print elements of TreeSet
    public static void display(TreeSet<Integer> set) {
        for (int num : set) {
            System.out.print(num + " ");
        }
    }

    // Function to erase element x from TreeSet
    public static void erase(TreeSet<Integer> set, int x) {
        if (set.contains(x)) {
            set.remove(x);
            System.out.print("erased " + x);
        } else {
            System.out.print("not found");
        }
    }
}