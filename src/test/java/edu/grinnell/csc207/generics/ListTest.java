package edu.grinnell.csc207.generics;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ListTest<T>{

    @Test
    public void emptyListTest(List<Integer> l, List<String> s) {
        assertEquals(0, l.size());
        assertEquals(0, s.size());
    }

    @Test
    public void listAddSize10Nums(List<Integer> l, List<String> s) {
        for (int i = 0; i < 10; i++) {
            l.add(i);
            s.add("Hello");
        }
        assertEquals(10, l.size());
        assertEquals(10, s.size());
    }

    @Test
    public void listAddNegNums(List<Integer> l, List<String> s) {
        l.add(-3);
        l.add(-10);
        l.add(-22);
        s.add("Hello");
        s.add("Bonjour");
        s.add("Ciao");
        assertEquals(-3, l.get(0));
        assertEquals(-10, l.get(1));
        assertEquals(-22, l.get(2));
        assertEquals("Hello", s.get(0));
        assertEquals("Bonjour", s.get(1));
        assertEquals("Ciao", s.get(2));
    }

    @Test
    public void listGetSeveral(List<Integer> l, List<String> s) {
        int[] elements = new int[] {3, 8, 7, 2, 6, 5, 0};
        String[] strs = new String[] {"Hello", "World", "Goodbye", "Bonjour", "Ciao", "Wagwan", "Arigato"};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
            s.add(strs[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
            assertEquals(strs[i], s.get(i));
        }
    }

    @Test
    public void listGetOOB(List<Integer> l, List<String> s) {
        l.add(3);
        l.add(2);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });

        s.add("Chao");
        s.add("Banh Mi");
        s.add("Sushi");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            s.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            s.get(3);
        });
    }

    @Test
    public void listRemoveSome(List<Integer> l, List<String> s) {
        l.add(5);
        l.add(8);
        l.add(7);
        l.add(1);
        l.add(9);
        
        s.add("Hello");
        s.add("Goodbye");
        s.add("Hola");
        s.add("Bonjour");
        s.add("Ciao");
        
        assertEquals(7, l.remove(2));
        assertEquals(8, l.get(1));
        assertEquals(1, l.get(2));
        
        assertEquals(5, l.remove(0));
        assertEquals(8, l.get(0));

        assertEquals(9, l.remove(2));
        assertEquals(1, l.get(1));
        
        // String list
        assertEquals("Hola", s.remove(2));
        assertEquals("Goodbye", s.get(1));
        assertEquals("Bonjour", s.get(2));
        
        assertEquals("Hello", s.remove(0));
        assertEquals("Goodbye", s.get(0));

        assertEquals("Ciao", s.remove(2));
        assertEquals("Bonjour", s.get(1));
    }

    @Test
    public void listRemoveOOB(List<Integer> l, List<String> s) {
        l.add(5);
        l.add(8);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });

        s.add("Ramen");
        s.add("Gyoza");
        s.add("Carbonara");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            s.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            s.remove(3);
        });
    }

}