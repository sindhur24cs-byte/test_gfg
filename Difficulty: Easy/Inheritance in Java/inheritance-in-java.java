// Parent Class
class Employee {
    int id;
    int salary;

    // Parameterized constructor
    public Employee(int id, int salary) {
        this.id = id;
        this.salary = salary;
    }
}

// Child Class extending Employee
class SalesEmployee extends Employee {
    int sales;

    // Parameterized constructor using super() to call parent constructor
    public SalesEmployee(int id, int salary, int sales) {
        super(id, salary); // Initializes id and salary from Employee class
        this.sales = sales;
    }
}