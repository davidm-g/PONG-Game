package com.pong.Controller;


import com.pong.Game;
import com.pong.controller.game.Paddle2Controller;
import com.pong.gui.GUI;
import com.pong.model.Position;
import com.pong.model.game.arena.Arena;
import com.pong.model.game.elements.Paddle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class Paddle2ControllerTest {
    private Paddle2Controller controller;

    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = Mockito.mock(Arena.class);
        controller = new Paddle2Controller(arena);
    }

    @Test
    void movePaddle2UP() {
        Paddle Paddle2 = new Paddle(40, 10);
        Mockito.when(arena.CheckPosPaddle(any(Position.class))).thenReturn(true);
        Mockito.when(arena.getPaddle2()).thenReturn(Paddle2);
        controller.movePaddle2Up();
        Mockito.verify(arena, Mockito.times(2)).getPaddle2();
        Mockito.verify(arena, Mockito.times(1)).CheckPosPaddle(Paddle2.getPosition());
        assertEquals(new Position(40, 9), Paddle2.getPosition());
    }

    @Test
    void movePaddle2Down() {
        Paddle Paddle2 = new Paddle(40, 10);
        Mockito.when(arena.CheckPosPaddle(any(Position.class))).thenReturn(true);
        Mockito.when(arena.getPaddle2()).thenReturn(Paddle2);
        controller.movePaddle2Down();
        Mockito.verify(arena, Mockito.times(2)).getPaddle2();
        Mockito.verify(arena, Mockito.times(1)).CheckPosPaddle(Paddle2.getPosition());
        assertEquals(new Position(40, 11), Paddle2.getPosition());
    }

    @Test
    void testStepUp() throws IOException, URISyntaxException, FontFormatException {
        Paddle2Controller paddle2ControllerSpy = Mockito.spy(new Paddle2Controller(arena));
        GUI.ACTION action = GUI.ACTION.PADDLE2UP;
        Paddle Paddle2 = new Paddle(40, 10);
        Mockito.when(arena.getPaddle2()).thenReturn(Paddle2);
        Game game = new Game();
        paddle2ControllerSpy.step(game, action, 0);
        Mockito.verify(paddle2ControllerSpy, Mockito.times(1)).movePaddle2Up();

    }

    @Test
    void testStepDown() throws IOException, URISyntaxException, FontFormatException {
        Paddle2Controller paddle2ControllerSpy = Mockito.spy(new Paddle2Controller(arena));
        GUI.ACTION action = GUI.ACTION.PADDLE2DOWN;
        Paddle Paddle2 = new Paddle(40, 10);
        Mockito.when(arena.getPaddle2()).thenReturn(Paddle2);
        Game game = new Game();
        paddle2ControllerSpy.step(game, action, 0);
        Mockito.verify(paddle2ControllerSpy, Mockito.times(1)).movePaddle2Down();


    }
}
