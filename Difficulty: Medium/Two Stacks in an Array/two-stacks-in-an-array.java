class twoStacks {
    int[] arr;
    int top1, top2;

    twoStacks() {
        arr = new int[100];
        top1 = -1;
        top2 = arr.length;
    }

    void push1(int x) {
        if (top1 + 1 < top2) {
            arr[++top1] = x;
        }
    }

    void push2(int x) {
        if (top1 + 1 < top2) {
            arr[--top2] = x;
        }
    }

    int pop1() {
        if (top1 == -1)
            return -1;

        return arr[top1--];
    }

    int pop2() {
        if (top2 == arr.length)
            return -1;

        return arr[top2++];
    }
}