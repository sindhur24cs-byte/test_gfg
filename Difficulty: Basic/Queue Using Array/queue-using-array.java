class myQueue {
    int arr[];
    int front;
    int rear;
    int capacity;

    myQueue(int n) {
        capacity = n;
        arr = new int[n];
        front = 0;
        rear = -1;
    }

    public void enqueue(int x) {
        if (isFull()) {
            return;
        }

        arr[++rear] = x;
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }

        int value = arr[front];

        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }

        rear--;

        return value;
    }

    // Return front element
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return arr[rear];
    }

    public boolean isEmpty() {
        return rear < front;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }
}