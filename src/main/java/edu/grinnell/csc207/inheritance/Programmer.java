package edu.grinnell.csc207.inheritance;

/** A programmer. */
public class Programmer extends Employee {


    /**
     * Constructs a new programmer.
     *
     * @param name the programmer's name.
     * @param id the programmer's ID.
     */
    public Programmer(String name, String id) {
        super("(PROG) " + name, id, 80000 * 2, "Clack clack clack");
    }

}
