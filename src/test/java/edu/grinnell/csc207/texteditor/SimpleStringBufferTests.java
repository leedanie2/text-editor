package edu.grinnell.csc207.texteditor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class SimpleStringBufferTests {
    /**
     * Tests grabbing an OOB index (getChar()), moving right past size (moveRight()), 
     * moving left past 0 (moveLeft()), deleting from empty buffer (delete())
     */
    @Test
    public void cornerBufferTest() {
        SimpleStringBuffer testBuffer = new SimpleStringBuffer();
        assertEquals(0, testBuffer.getCursorPosition());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testBuffer.getChar(5);
        testBuffer.insert('H');
        assertEquals(1, testBuffer.getCursorPosition());
        testBuffer.moveRight();
        assertEquals(1, testBuffer.getCursorPosition());
        testBuffer.moveLeft();
        testBuffer.moveLeft();
        testBuffer.moveLeft();
        assertEquals(0, testBuffer.getCursorPosition());
        testBuffer.delete();
        assertEquals("", testBuffer.toString());
        
        });
    }

    /**
     * Tests insert(), delete(), getSize(), getCursorPosition(), toString(), getChar() over a simple string
     */
    @Test
    public void basicUseCase() {
        SimpleStringBuffer buff = new SimpleStringBuffer();
        buff.insert('H');
        buff.insert('e');
        buff.insert('l');
        buff.insert('l');
        buff.insert('o');
        assertEquals(5, buff.getSize());
        assertEquals(5, buff.getCursorPosition());
        assertEquals("Hello", buff.toString());
        buff.delete();
        assertEquals(4, buff.getSize());
        assertEquals(4, buff.getCursorPosition());
        assertEquals("Hell", buff.toString());
        buff.moveLeft();
        assertEquals(3, buff.getCursorPosition());
        assertEquals('e', buff.getChar(1));
        buff.insert('a');
        assertEquals('a', buff.getChar(3));
        assertEquals("Helal", buff.toString());
        buff.moveRight();
        assertEquals(5, buff.getCursorPosition());
    }
    
    /**
     * Tests getSize() after inserting any arbitrary number of characters
     */
    @Property
    public boolean sizeTest(@ForAll @IntRange(min = 0, max = 1000) int n) {
        SimpleStringBuffer buff = new SimpleStringBuffer();
        for(int i = 0; i < n; i++) {
            buff.insert('a');
        }
        return (buff.getSize() == n);
    }
}
