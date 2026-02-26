package edu.grinnell.csc207.inheritance;

/** An accountant. */
public class Accountant extends Employee {

    /**
     * Constructs a new accountant
     * @param name the accountant's name
     * @param id the accountant's ID
     */
    public Accountant(String name, String id) {
        super("(ACCT) " + name, id, 80000, "$$$");
    }

}
