class GenericClass<T> {
    private T data;

    // Constructor to set the value
    public GenericClass(T data) {
        this.data = data;
    }

    // Driver code calls showType() to print the data type and value
    public void showType() {
        // SimpleName prints "String" or "Integer"
        System.out.println(data.getClass().getSimpleName());
        System.out.println(data);
    }
}