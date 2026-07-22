class Solution {
    public int getLastDigit(String a, String b) {
        int base = (a.charAt(a.length() - 1) - '0');

        // a^0 = 1
        if (b.equals("0")) {
            return 1;
        }

        int result = 1;

        for (int i = 0; i < b.length(); i++) {
            int digit = b.charAt(i) - '0';

            // result = result^10 * base^digit (mod 10)
            result = modPower(result, 10);
            result = (result * modPower(base, digit)) % 10;
        }

        return result;
    }

    private int modPower(int base, int exponent) {
        int result = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % 10;
            }

            base = (base * base) % 10;
            exponent /= 2;
        }

        return result;
    }
}