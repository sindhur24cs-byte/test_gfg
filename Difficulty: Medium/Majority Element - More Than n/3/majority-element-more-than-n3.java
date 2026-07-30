class Solution {
    public List<Integer> findMajority(int[] arr) {
        int n = arr.length;
        int count1 = 0, count2 = 0;
        int cand1 = 0, cand2 = 1;

        for (int num : arr) {
            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : arr) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
        }

        List<Integer> ans = new ArrayList<>();

        if (count1 > n / 3) ans.add(cand1);
        if (count2 > n / 3) ans.add(cand2);

        Collections.sort(ans);
        return ans;
    }
}