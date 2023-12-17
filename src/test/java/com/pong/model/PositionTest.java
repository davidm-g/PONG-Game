package com.pong.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
