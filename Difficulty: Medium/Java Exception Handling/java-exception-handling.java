class Solution {
    public int findMin(int a, int b) {
        // Calculate basic arithmetic operations
        int add = a + b;
        int sub = a - b;
        int mul = a * b;

        // Initialize minimum with addition result
        int minVal = Math.min(add, Math.min(sub, mul));

        // Use try-catch to safely handle potential Division by Zero (ArithmeticException)
        try {
            int div = a / b; // Performs floor division in Java for integers
            minVal = Math.min(minVal, div);
        } catch (ArithmeticException e) {
            // Division by zero occurred -> exclude division operation from consideration
        }

        return minVal;
    }
}