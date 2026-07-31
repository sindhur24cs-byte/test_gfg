class Solution {
    public ArrayList<Integer> sortByFreq(int[] arr) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);
            }
            return a - b;
        });

        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            ans.add(num);
        }

        return ans;
    }
}