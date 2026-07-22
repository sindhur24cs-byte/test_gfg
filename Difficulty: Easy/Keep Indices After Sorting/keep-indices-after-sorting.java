import java.util.ArrayList;
import java.util.Collections;

class Sorting {
    public ArrayList<ArrItem> sortedWithIndices(int arr[]) {
        ArrayList<ArrItem> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(new ArrItem(arr[i], i));
        }

        Collections.sort(list, (a, b) -> {
            if (a.item != b.item) {
                return Integer.compare(a.item, b.item);
            }
            return Integer.compare(a.index, b.index);
        });

        return list;
    }
}