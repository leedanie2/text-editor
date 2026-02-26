package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer implements Buffer {

    /**
     * Insert a char to the right of the cursor
     */
    public void insert(char ch) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    /**
     * Delete the char to the left of the cursor
     */
    public void delete() {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    /**
     * @returns the int index of the cursor position
     */
    public int getCursorPosition() {
        throw new UnsupportedOperationException("Unimplemented method 'getCursorPosition'");
    }

    /**
     * Move the cursor to the left
     */
    public void moveLeft() {
        throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
    }

    /**
     * Move the cursor to the right
     */
    public void moveRight() {
        throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
    }

    /**
     * @returns an int size of the buffer
     */
    public int getSize() {
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    /**
     * @returns a char at index i
     */
    public char getChar(int i) {
        throw new UnsupportedOperationException("Unimplemented method 'getChar'");
    }

    /**
     * converts the buffer array to a string and returns the string. 
     * @returns a string 
     */
    public String toString() {
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
