package edu.grinnell.csc207.inheritance;

import java.util.List;

/** A manager. */
public class Manager extends Employee {

    private List<Employee> reportees;

    /**
     * Constructs a new manager.
     *
     * @param name the manager's name.
     * @param id the manager's ID.
     * @param reportees the manager's direct reports.
     */
    public Manager(String name, String id, List<Employee> reportees) {
        super("(MGR) " + name, id, 120000 * 3, "Do Work Do Work Do Work");
        this.reportees = reportees;
    }
}
