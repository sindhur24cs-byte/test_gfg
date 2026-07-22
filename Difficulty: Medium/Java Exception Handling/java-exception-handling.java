class Solution {
    public int findMin(int a, int b) {
        // Calculate the results of valid operations
        int add = a + b;
        int sub = a - b;
        int mul = a * b;

        // Start min with the minimum of addition, subtraction, and multiplication
        int minVal = Math.min(add, Math.min(sub, mul));

        // Use try-catch to safely perform division
        try {
            int div = a / b;
            minVal = Math.min(minVal, div);
        } catch (ArithmeticException e) {
            // Division by zero attempted -> exclude division from comparison
        }

        return minVal;
    }
}