package edu.grinnell.csc207.generics;

import java.util.Arrays;

/**
 * An array-based implementation of a list, specialized to ints.
 */
public class ArrayList<T> implements List<T> {

    private static final int INITIAL_SIZE = 8;
    private T[] data;
    private int sz;
    
    /**
     * Constructs a new, empty array list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.data = (T[]) new Object[INITIAL_SIZE];
        this.sz = 0;
    }
    private void ensureCapacity() {
        if (sz == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    @Override
    public void add(T value) {
        ensureCapacity();
        data[sz++] = value;
    }

    /**
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        }
        return data[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        } else {
            T ret = data[index];
            for (int i = index; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            sz -= 1;
            return ret;
        }
    }

    /**
     * Inserts sep between each element of the list
     */
    public void intersperse(T sep) {
        T[] arr = (T[]) new Object[sz*2];
        for(int i = 1; i < sz*2; i++) {
            if(i % 2 == 0) {
                arr[i] = data[i/2];
            } else {
                arr[i] = sep;
            }
        }
        data = arr;
    }

    /**
     * Finds maximum of list
     */
    public T maximum() {
        T max = data[0];
        if (max instanceof String){
            throw new UnsupportedOperationException();
        }
        for (int i = 1; i < sz; i++){
            if ((int)max < (int)data[i]){
                max = data[i];
            }
        }
        return max;
    }
    
    public String toString() {
        String str = new String();
        for (int i = 0; i < sz - 1; i++) {
            str = str + String.valueOf(data[i]) + ", ";
        }
        str = str + String.valueOf(data[sz-1]) + "]";
        return str;
    }

    public void insertionSort() {
        T item = data[0];
        if (item instanceof String){
            throw new UnsupportedOperationException();
        }
        for(int i = 1; i < sz; i++) {
            T tmp = data[i];
            int j = i - 1;
            while(j >= 0 && (Integer) data[j] < (Integer) tmp) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = tmp; // complete swap
        }
    }
}
