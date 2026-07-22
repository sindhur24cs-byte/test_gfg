import java.util.TreeMap;

class GfG {
    // 1. Add key-value pair (x, y) to TreeMap
    void add_Value(TreeMap<Integer, Integer> hm, int x, int y) {
        hm.put(x, y);
    }

    // 2. Return value for key x if present, else return -1
    int find_value(TreeMap<Integer, Integer> hm, int x) {
        return hm.getOrDefault(x, -1);
    }

    // 3. Return size of the TreeMap
    int getSize(TreeMap<Integer, Integer> hm) {
        return hm.size();
    }

    // 4. Remove key x from TreeMap
    void removeKey(TreeMap<Integer, Integer> hm, int x) {
        hm.remove(x);
    }

    // 5. Print elements sorted by key
    void sorted_By_Key(TreeMap<Integer, Integer> hm) {
        for (int key : hm.keySet()) {
            System.out.print(key + " ");
        }
    }
}