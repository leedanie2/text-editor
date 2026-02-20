package edu.grinnell.csc207.generics;

public interface List<T> {
    public void add(T value);
    public int size();
    public T get(int index);
    public T remove(int index);
}

