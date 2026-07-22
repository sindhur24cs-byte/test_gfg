class Solution {
    public Hello helperFunction() {
        // Implement sayHello() using a no-parameter lambda expression
        return () -> System.out.println("Hello");
    }
}