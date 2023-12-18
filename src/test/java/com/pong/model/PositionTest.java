package com.pong.model;

import net.jqwik.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private Position position;

    @Property
    void getPaddle1UP(@ForAll int x, @ForAll int y){

        assertEquals(x, new Position(x, y).getUp().getX());
        assertEquals(y - 1, new Position(x, y).getUp().getY());
    }

    @Property
    void getPaddle1Down(@ForAll int x, @ForAll int y){

        assertEquals(x, new Position(x, y).getDown().getX());
        assertEquals(y + 1, new Position(x, y).getDown().getY());
    }

    @Property
    void getPaddle2UP(@ForAll int x, @ForAll int y){

        assertEquals(x, new Position(x, y).getUp().getX());
        assertEquals(y - 1, new Position(x, y).getUp().getY());
    }

    @Property
    void getPaddle2Down(@ForAll int x, @ForAll int y){

        assertEquals(x, new Position(x, y).getDown().getX());
        assertEquals(y + 1, new Position(x, y).getDown().getY());
    }

    @Property
    public void testGetdirection(@ForAll int x, @ForAll int y, @ForAll int xv, @ForAll int yv){
        Position position1 = new Position(x,y);
        Position newpositon = position1.getDirection(xv,yv);

        assertEquals(x + xv, newpositon.getX());
        assertEquals(y + yv, newpositon.getY());
    }

    @Property
    public void testtoString(@ForAll int x, @ForAll int y){
        Position position1 = new Position(x,y);
        String expectedString = "Position{x=" + x + ", y=" + y + "}";
        String result = position1.toString();

        assertEquals(expectedString,result);
    }
    
    @Test
    public void testEqualsSamePos(){
        Position position1 = new Position(5,10);
        Position position2 = new Position(5,10);

        assertTrue(position1.equals(position2));
        assertEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    public void testEqualsDiffPos(){
        Position position1 = new Position(5,10);
        Position position2 = new Position(8,15);

        assertFalse(position1.equals(position2));
        assertNotEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    public void testcomparePositions(){
        Position position1 = new Position(5,10);


        assertTrue(position1.equals(position1));
    }
    @Test
    public void testcompareNonPositions(){
        Position position1 = new Position(5,10);
        Object obj = new Object();

        assertFalse(position1.equals(obj));
    }

    

}
