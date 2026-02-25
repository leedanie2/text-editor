package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer implements Buffer {
    private String buffer;
    private int i;
    private int sz;

    /**
     * Constructor for buffer
     */
    public SimpleStringBuffer() {
        buffer = new String();
        i = 0;
        sz = 0;
    }
    /**
     * Add characters to the buffer
     */
    public void insert(char ch) {
        buffer = buffer.substring(0, i) + ch + buffer.substring(i);
        i++;
        sz++;
    }

    /**
     * Delete characters from the buffer
     */
    public void delete() {
        if (sz > 0){
            buffer = buffer.substring(0, i-1) + buffer.substring(i);
            i--;   
            sz--; 
        }
    }

    /**
     * Get the current position of the cursor
     * @return index of cursor position
     */
    public int getCursorPosition() {
        return i;
    }

    /**
     * Move cursor to the left if possible
     */
    public void moveLeft() {
        if (i > 0){
            i--;
        }
    }

    /**
     * Move cursor to the right if possible
     */
    public void moveRight() {
        if(i < sz) {
            i++;
        }
    }

    /**
     * Get the current size
     * @return size of buffer
     */
    public int getSize() {
        return sz;
    }

    /**
     * Get the character at specified index of buffer
     * @return character at <i>th index
     */
    public char getChar(int i) {
        if (i < 0 || i > sz){
            throw new IndexOutOfBoundsException();
        }
        return buffer.charAt(i);
    }

    /**
     * Return buffer as a string
     * @return buffer
     */
    @Override
    public String toString() {
        return buffer;
    }
}
