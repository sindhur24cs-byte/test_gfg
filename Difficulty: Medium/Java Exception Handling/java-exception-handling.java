class Solution {
    public static int findMin(int a, int b) {
        // Calculate standard operations
        int add = a + b;
        int sub = a - b;
        int mul = a * b;

        // Start min with the addition result
        int minVal = Math.min(add, Math.min(sub, mul));

        // Try floor division with exception handling
        try {
            int div = a / b;
            minVal = Math.min(minVal, div);
        } catch (ArithmeticException e) {
            // Division by zero occurred — ignore division and proceed
        }

        return minVal;
    }
}