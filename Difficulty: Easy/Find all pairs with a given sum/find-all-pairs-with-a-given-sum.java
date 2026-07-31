class Solution {
    public pair[] allPairs(int x, int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(arr1);

        ArrayList<pair> ans = new ArrayList<>();

        for (int num : arr1) {
            int need = x - num;

            if (map.containsKey(need)) {
                int cnt = map.get(need);

                for (int i = 0; i < cnt; i++) {
                    ans.add(new pair(num, need));
                }
            }
        }

        return ans.toArray(new pair[0]);
    }
}