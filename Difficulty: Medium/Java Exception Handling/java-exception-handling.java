class Solution {
    public int findMin(int a, int b) {
        int add = a + b;
        int sub = a - b;
        int mul = a * b;

        // Start with the minimum among addition, subtraction, and multiplication
        int minVal = Math.min(add, Math.min(sub, mul));

        // Use exception handling for division
        try {
            int div = a / b;
            minVal = Math.min(minVal, div);
        } catch (ArithmeticException e) {
            // Division by zero occurred; ignore division and keep the current minimum
        }

        return minVal;
    }
}