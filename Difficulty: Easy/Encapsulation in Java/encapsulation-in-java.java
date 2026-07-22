class Person {
    // Private attributes (data hiding)
    private String name = "Geeks";
    private int age = 10;

    // Default constructor
    public Person() {
        // Values are initialized by default field definitions
    }

    // Getter for name
    public String getName() {
        return this.name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return this.age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }
}