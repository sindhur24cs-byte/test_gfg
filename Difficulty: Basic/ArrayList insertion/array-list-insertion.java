import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> fillArrayList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}