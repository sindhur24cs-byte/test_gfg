import java.util.LinkedList;

class Solution {
    public static LinkedList<Integer> insertion(int arr[]) {
        LinkedList<Integer> list = new LinkedList<>();

        // Add each array element into the LinkedList
        for (int num : arr) {
            list.add(num);
        }

        return list;
    }
}