class Solution {
    static boolean canRepresentBST(List<Integer> arr) {
        Stack<Integer> stack = new Stack<>();

        int root = Integer.MIN_VALUE;

        for (int value : arr) {

            if (value < root) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() < value) {
                root = stack.pop();
            }

            stack.push(value);
        }

        return true;
    }
}