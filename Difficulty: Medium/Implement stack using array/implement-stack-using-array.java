class myStack {
    int arr[];
    int top;
    int capacity;

    myStack(int n) {
        capacity = n;
        arr = new int[n];
        top = -1;
    }

    // Push element x
    public void push(int x) {
        if (isFull()) {
            return;
        }

        arr[++top] = x;
    }

    // Remove top element
    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        return arr[top--];
    }

    // Return top element
    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return arr[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }
}