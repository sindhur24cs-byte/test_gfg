class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {

        ArrayList<Integer> list = new ArrayList<>();

        // Initially the array contains 0
        list.add(0);

        int xorValue = 0;

        for (int[] query : queries) {

            if (query[0] == 0) {
                // Store adjusted value
                list.add(query[1] ^ xorValue);
            } else {
                // Apply XOR lazily
                xorValue ^= query[1];
            }
        }

        // Apply final XOR to all elements
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) ^ xorValue);
        }

        Collections.sort(list);

        return list;
    }
}