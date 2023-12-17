package com.pong.model;

import com.pong.model.Winner.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WinnerTest {
    private Winner winner1;
    private Winner winner2;
    @BeforeEach
    public void setup(){
        winner1 = new Winner(1);
        winner2 = new Winner(2);
    }

    @Test
    public void testGetPlayNum(){
        assertEquals(1,winner1.getPlaynumber());
        assertEquals(2,winner2.getPlaynumber());

    }

    @Test
    void testNextEntry(){
        winner1.nextEntry();
        assertEquals(1,winner1.getCurrentEntry());
        winner1.nextEntry();
        assertEquals(0,winner1.getCurrentEntry());

        winner2.nextEntry();
        assertEquals(1,winner2.getCurrentEntry());
        winner2.nextEntry();
        assertEquals(0,winner2.getCurrentEntry());
    }

    @Test
    public void testPreviousEntry(){
        winner1.previousEntry();
        assertEquals(1,winner1.getCurrentEntry());
        winner1.previousEntry();
        assertEquals(0,winner1.getCurrentEntry());

        winner2.previousEntry();
        assertEquals(1,winner2.getCurrentEntry());
        winner2.previousEntry();
        assertEquals(0,winner2.getCurrentEntry());
    }
    @Test
    public void testGetEntry() {
        assertEquals("Play Again", winner1.getEntry(0));
        assertEquals("Return to Menu", winner1.getEntry(1));

        assertEquals("Play Again", winner2.getEntry(0));
        assertEquals("Return to Menu", winner2.getEntry(1));
    }
    @Test
    public void testIsSelected(){
        assertTrue(winner1.isSelectedPlay());
        assertFalse(winner1.isSelectedMenu());

        assertFalse(winner1.isSelected(1));
        assertTrue(winner1.isSelected(0));

        winner1.nextEntry();

        assertFalse(winner1.isSelectedPlay());
        assertTrue(winner1.isSelectedMenu());

        assertTrue(winner1.isSelected(1));
        assertFalse(winner1.isSelected(0));


        assertTrue(winner2.isSelectedPlay());
        assertFalse(winner2.isSelectedMenu());

        assertFalse(winner2.isSelected(1));
        assertTrue(winner2.isSelected(0));

        winner2.nextEntry();

        assertFalse(winner2.isSelectedPlay());
        assertTrue(winner2.isSelectedMenu());

        assertTrue(winner2.isSelected(1));
        assertFalse(winner2.isSelected(0));

    }
    @Test
    public void testGetNumberEntries(){
        assertEquals(2,winner1.getNumberEntries());
        assertEquals(2,winner2.getNumberEntries());
    }
}
