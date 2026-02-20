package edu.grinnell.csc207.generics;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ListTest {

    @Test
    public void listBasicUsageTest(List<Integer> lst) {
        assertEquals(0, lst.size());
        lst.add(5);
        lst.add(9);
        lst.add(7);
        assertEquals(3, lst.size());
        assertEquals(9, lst.get(1));
        assertEquals(9, lst.remove(1));
        assertEquals(7, lst.get(1));
        assertEquals(2, lst.size());
    }

    @Test
    public void listBasicUsageTestString(List<String> lst) {
        assertEquals(0, lst.size());
        lst.add("Hello");
        lst.add("Goodbye");
        lst.add("Bonjour");
        assertEquals(3, lst.size());
        assertEquals(9, lst.get(1));
        assertEquals(9, lst.remove(1));
        assertEquals(7, lst.get(1));
        assertEquals(2, lst.size());
    }
    
}


