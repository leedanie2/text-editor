package edu.grinnell.csc207.inheritance;

/** An employee. */
public abstract class Employee {
    protected String name;
    protected String id;
    protected int salary;
    protected String noise;

    public Employee(String name, String id, int salary, String noise) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.noise = noise;
    }

    /** @return the employee's name. */
    String getName() { return name; }

    /** @return the employee's ID. */
    String getId() { return id; };

    /** @return the employee's salary. */
    int getSalary() { return salary; };

    /** @return the noise the employee makes while working. */
    String makeWorkNoise() { return noise; };

}
