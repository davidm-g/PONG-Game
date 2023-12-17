package com.pong.model;

import com.pong.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private Menu menu;
    @BeforeEach
    void setup(){
        menu = new Menu();
    }

    @Test
    void testNextEntry(){
        menu.nextEntry();
        assertEquals(1,menu.getCurrentEntry());
        menu.nextEntry();
        assertEquals(0,menu.getCurrentEntry());
    }

    @Test
    public void testPreviousEntry(){
        menu.previousEntry();
        assertEquals(1,menu.getCurrentEntry());
        menu.previousEntry();
        assertEquals(0,menu.getCurrentEntry());
    }
    @Test
    public void testGetEntry(){
        assertEquals("Play",menu.getEntry(0));
        assertEquals("Leave Game", menu.getEntry(1));
    }
    @Test
    public void testIsSelected(){
        assertTrue(menu.isSelectedPlay());
        assertFalse(menu.isSelectedLeave());

        assertFalse(menu.isSelected(1));
        assertTrue(menu.isSelected(0));

        menu.nextEntry();

        assertFalse(menu.isSelectedPlay());
        assertTrue(menu.isSelectedLeave());

        assertTrue(menu.isSelected(1));
        assertFalse(menu.isSelected(0));

    }
    @Test
    public void testGetNumberEntries(){
        assertEquals(2,menu.getNumberEntries());
    }

}
