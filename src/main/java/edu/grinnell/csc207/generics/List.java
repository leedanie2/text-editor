package edu.grinnell.csc207.generics;

/**
 * Interface for lists
 */
public interface List<T> {

    /**
     * Adds a value to list
     * @param value to add
     */

    public void add(T value);

    /**
     * returns int size
     * @return int size.
     */

    public int size();

    /**
     * returns element at index
     * @param index to access
     * @return element
     */
    public T get(int index);

    /**
     * remmoves element at index
     * @param index to access
     * @return element
     */
    public T remove(int index);
}

