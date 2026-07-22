/* Structure of Interface
interface in1 {
    void display(int p);
}
*/

class testClass implements in1 {
    // Implementing the display method defined in interface in1
    public void display(int p) {
        int primeCount = 0;

        // Count prime numbers from 2 up to p (inclusive)
        for (int i = 2; i <= p; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }

        System.out.println(primeCount);
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}