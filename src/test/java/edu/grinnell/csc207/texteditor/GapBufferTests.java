package edu.grinnell.csc207.texteditor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class GapBufferTests {
    /**
     * Tests grabbing an OOB index (getChar()), moving right past size (moveRight()), 
     * moving left past 0 (moveLeft()), deleting from empty buffer (delete())
     */
    @Test
    public void cornerBufferTest() {
        GapBuffer testBuffer = new GapBuffer();
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
        for(int i = 0; i < 12; i++){
            testBuffer.insert('H');
        }
        assertEquals(12, testBuffer.getCursorPosition());
        assertEquals("HHHHHHHHHHH", testBuffer.toString());
        assertEquals(20, testBuffer.getSize());
        });
    }

    /**
     * Tests insert(), delete(), getSize(), getCursorPosition(), toString(), getChar() over a simple string
     */
    @Test
    public void basicUseCase() {
        GapBuffer buff = new GapBuffer();
        buff.insert('H');
        buff.insert('e');
        buff.insert('l');
        buff.insert('l');
        buff.insert('o');
        assertEquals(10, buff.getSize());
        assertEquals(5, buff.getCursorPosition());
        assertEquals("Hello", buff.toString());
        buff.delete();
        assertEquals(10, buff.getSize());
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
        GapBuffer buff = new GapBuffer();
        for(int i = 0; i < n; i++) {
            buff.insert('a');
        }
        int expectedSize = 10;
        while (expectedSize <= n) {
            expectedSize *= 2;
        }
        return (buff.getSize() == expectedSize);
    }
}
