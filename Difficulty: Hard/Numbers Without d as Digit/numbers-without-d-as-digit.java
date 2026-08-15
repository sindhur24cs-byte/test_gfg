class Solution {
    public int countWithout(int n, int d) {
        if (n <= 0) return 0;

        String s = String.valueOf(n);
        int len = s.length();
        int count = 0;

        // 1. Count valid numbers with fewer digits than n
        for (int i = 1; i < len; i++) {
            int firstDigitChoices = (d == 0) ? 9 : 8;
            count += firstDigitChoices * (int) Math.pow(9, i - 1);
        }

        // 2. Count valid numbers with the same digit length as n
        boolean nIsValid = true;
        for (int i = 0; i < len; i++) {
            int currentDigit = s.charAt(i) - '0';

            for (int digit = 0; digit < currentDigit; digit++) {
                if (i == 0 && digit == 0) continue; // Skip leading zero
                if (digit == d) continue;           // Skip digit d

                count += (int) Math.pow(9, len - 1 - i);
            }

            if (currentDigit == d) {
                nIsValid = false;
                break;
            }
        }

        // Add 1 if n itself does not contain digit d
        if (nIsValid) {
            count++;
        }

        return count;
    }
}