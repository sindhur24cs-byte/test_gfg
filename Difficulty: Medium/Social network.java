import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = arr.length + 1;

        for (int i = 2; i <= n; i++) {
            int current = i;
            int distance = 0;

            ArrayList<Integer> users = new ArrayList<>();
            ArrayList<Integer> dist = new ArrayList<>();

            while (current != 1) {
                current = arr[current - 2];
                distance++;

                users.add(current);
                dist.add(distance);
            }

            for (int j = 1; j < i; j++) {
                for (int x = 0; x < users.size(); x++) {
                    if (users.get(x) == j) {
                        ArrayList<Integer> temp = new ArrayList<>();

                        temp.add(i);
                        temp.add(j);
                        temp.add(dist.get(x));

                        ans.add(temp);
                    }
                }
            }
        }

        return ans;
    }
}
