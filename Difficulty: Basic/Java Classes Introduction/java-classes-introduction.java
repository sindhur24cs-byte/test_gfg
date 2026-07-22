class task {
    private int length;
    private int width;
    private int height;

    public void set_length(int l) {
        this.length = l;
    }

    public void set_width(int w) {
        this.width = w;
    }

    public void set_height(int h) {
        this.height = h;
    }

    public void volume() {
        System.out.println(length * width * height);
    }
}