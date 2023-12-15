package com.aor.pong.model;

import com.aor.pong.model.menu.Menu;
import com.aor.pong.model.mode.Mode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModeTest {
    private Mode mode;
    @BeforeEach
    void setup(){
        mode = new Mode();
    }

    @Test
    void testNextEntry(){
        mode.nextEntry();
        assertEquals(1,mode.getCurrentEntry());
        mode.nextEntry();
        assertEquals(2,mode.getCurrentEntry());
        mode.nextEntry();
        assertEquals(0,mode.getCurrentEntry());
    }

    @Test
    public void testPreviousEntry(){
        mode.previousEntry();
        assertEquals(2,mode.getCurrentEntry());
        mode.previousEntry();
        assertEquals(1,mode.getCurrentEntry());
        mode.previousEntry();
        assertEquals(0,mode.getCurrentEntry());
    }
    @Test
    public void testGetEntry(){
        assertEquals("Easy",mode.getEntry(0));
        assertEquals("Medium", mode.getEntry(1));
        assertEquals("Hard", mode.getEntry(2));

    }
    @Test
    public void testIsSelected(){
        assertTrue(mode.isSelectedEasy());
        assertFalse(mode.isSelectedMedium());
        assertFalse(mode.isSelectedHard());

        assertTrue(mode.isSelected(0));
        assertFalse(mode.isSelected(1));
        assertFalse(mode.isSelected(2));

        mode.nextEntry();

        assertFalse(mode.isSelectedEasy());
        assertTrue(mode.isSelectedMedium());
        assertFalse(mode.isSelectedHard());

        assertFalse(mode.isSelected(0));
        assertTrue(mode.isSelected(1));
        assertFalse(mode.isSelected(2));

        mode.nextEntry();

        assertFalse(mode.isSelectedEasy());
        assertFalse(mode.isSelectedMedium());
        assertTrue(mode.isSelectedHard());

        assertFalse(mode.isSelected(0));
        assertFalse(mode.isSelected(1));
        assertTrue(mode.isSelected(2));

    }
    @Test
    public void testGetNumberEntries(){
        assertEquals(3,mode.getNumberEntries());
    }
}
