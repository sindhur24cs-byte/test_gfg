class Solution {

    public int nextPrime(int n) {

        int num = n + 1;

        while (true) {
            boolean prime = true;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime)
                return num;

            num++;
        }
    }
}