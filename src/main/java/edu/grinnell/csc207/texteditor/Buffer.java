package edu.grinnell.csc207.texteditor;

/**
 * A buffer captures the backing data structure for our text editor.
 */
public interface Buffer {

    /**
     * insert char into buffer
     * @param ch
     */
    public void insert(char ch);

    /**
     * delete char from buffer
     */
    public void delete();

    /**
     * @return cursor position
     */
    public int getCursorPosition();

    /**
     * move cursor to the left
     */
    public void moveLeft();

    /**
     * move cursor to the right
     */
    public void moveRight();

    /**
     * @return int size of buffer
     */
    public int getSize();

    /**
     * @param i
     * @return char at index i
     * 
     */
    public char getChar(int i);

    /**
     * @return String of buffer
     */
    public String toString();
}
