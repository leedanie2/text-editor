package edu.grinnell.csc207.inheritance;

import java.util.List;

/** A CEO. */
public class CEO extends Manager {

    /**
     * Constructs a new CEO.
     *
     * @param name the CEO's name.
     * @param id the CEO's ID.
     * @param reportees the CEO's direct reports.
     */
    public CEO(String name, String id, List<Employee> reportees) {
        super("(CEO) " + name, id, reportees);
        this.salary = 80000 * 100;
        this.noise = "Do More Work More Do More Work More Do More Work";
    }
}
