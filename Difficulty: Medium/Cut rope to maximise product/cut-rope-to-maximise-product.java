public class Solution {

    public static long maxProduct(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        long product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;

        return product;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(2));
        System.out.println(maxProduct(5));
        System.out.println(maxProduct(10));
        System.out.println(maxProduct(58));
    }
}