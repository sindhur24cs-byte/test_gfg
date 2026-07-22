import java.math.BigInteger;

class Solution {
    public static BigInteger fib(int n) {
        if (n <= 2) {
            return BigInteger.ONE;
        }

        BigInteger a = BigInteger.ONE; // 1st Fibonacci number
        BigInteger b = BigInteger.ONE; // 2nd Fibonacci number
        BigInteger c = BigInteger.ZERO;

        for (int i = 3; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return b;
    }
}