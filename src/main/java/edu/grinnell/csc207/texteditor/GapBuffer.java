package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer implements Buffer {
    
    private char[] buffer;
    // indices of gap
    private int firstIndex;
    private int lastIndex;
    // size of array
    private int sz = 10;

    /**
     * Constructor for buffer
     */
    public GapBuffer() {
        buffer = new char[sz];
        firstIndex = 0;
        lastIndex = sz - 1;
    }


    /**
     * Insert a char to the right of the cursor
     */
    public void insert(char ch) {
        if(firstIndex == lastIndex) {
            char[] tmpBuff = new char[2*sz];
            for(int i = 0; i < firstIndex; i++) {
                tmpBuff[i] = buffer[i];
            }
            for(int i = firstIndex; i < sz; i++) {
                tmpBuff[i + firstIndex] = buffer[i];
            }
            buffer = tmpBuff;
            lastIndex += sz;
            sz *= 2;
        }
        buffer[firstIndex] = ch;
        firstIndex++;
    }

    /**
     * Delete the char to the left of the cursor
     */
    public void delete() {
        if(firstIndex > 0) {
            firstIndex--;
        }
    }

    /**
     * @returns the int index of the cursor position
     */
    public int getCursorPosition() {
        return firstIndex;
    }

    /**
     * Move the cursor to the left
     */
    public void moveLeft() {
        buffer[lastIndex-1] = buffer[firstIndex - 1];
        firstIndex--;
        lastIndex--;
    }

    /**
     * Move the cursor to the right
     */
    public void moveRight() {
        buffer[firstIndex] = buffer[lastIndex];
        firstIndex++;
        lastIndex++;
    }

    /**
     * @returns an int size of the buffer
     */
    public int getSize() {
        return sz;
    }

    /**
     * @returns a char at index i
     * @throws IndexOutOfBoundsException() if user passes in an invalid index ffor buffer
     */
    public char getChar(int i) {
        if(i >= sz || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return buffer[i];
    }

    /**
     * converts the buffer array to a string and returns the string. 
     * @returns a string 
     */
    public String toString() {
        String result = new String();
        result = "";
        for(int i = 0; i < firstIndex; i++) {
            result = result + String.valueOf(buffer[i]);
        }   
        for(int i = lastIndex; i < sz; i++) {
            result = result + String.valueOf(buffer[i]);
        }
        return result;
    }
}
