package com.aor.pong.Controller;


import com.aor.pong.Game;
import com.aor.pong.controller.game.Paddle1Controller;
import com.aor.pong.controller.game.Paddle2Controller;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.model.game.elements.Paddle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class Paddle1ControllerTest {
    private Paddle1Controller controller;

    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = Mockito.mock(Arena.class);
        controller = new Paddle1Controller(arena);
    }

    @Test
    void movePaddle1UP() {
        Paddle Paddle1 = new Paddle(40, 10);
        Mockito.when(arena.CheckPosPaddle(any(Position.class))).thenReturn(true);
        Mockito.when(arena.getPaddle1()).thenReturn(Paddle1);
        controller.movePaddle1Up();
        Mockito.verify(arena, Mockito.times(2)).getPaddle1();
        Mockito.verify(arena, Mockito.times(1)).CheckPosPaddle(Paddle1.getPosition());
        assertEquals(new Position(40, 9), Paddle1.getPosition());
    }

    @Test
    void movePaddle1Down() {
        Paddle Paddle1 = new Paddle(40, 10);
        Mockito.when(arena.CheckPosPaddle(any(Position.class))).thenReturn(true);
        Mockito.when(arena.getPaddle1()).thenReturn(Paddle1);
        controller.movePaddle1Down();
        Mockito.verify(arena, Mockito.times(2)).getPaddle1();
        Mockito.verify(arena, Mockito.times(1)).CheckPosPaddle(Paddle1.getPosition());
        assertEquals(new Position(40, 11), Paddle1.getPosition());
    }

    @Test
    void testStepUp() throws IOException, URISyntaxException, FontFormatException {
        Paddle1Controller paddle1ControllerSpy = Mockito.spy(new Paddle1Controller(arena));
        GUI.ACTION action = GUI.ACTION.PADDLE1UP;
        Paddle Paddle1 = new Paddle(40, 10);
        Mockito.when(arena.getPaddle1()).thenReturn(Paddle1);
        Game game = new Game();
        paddle1ControllerSpy.step(game, action, 0);
        Mockito.verify(paddle1ControllerSpy, Mockito.times(1)).movePaddle1Up();

    }

    @Test
    void testStepDown() throws IOException, URISyntaxException, FontFormatException {
        Paddle1Controller paddle1ControllerSpy = Mockito.spy(new Paddle1Controller(arena));
        GUI.ACTION action = GUI.ACTION.PADDLE1DOWN;
        Paddle Paddle1 = new Paddle(40, 10);
        Mockito.when(arena.getPaddle1()).thenReturn(Paddle1);
        Game game = new Game();
        paddle1ControllerSpy.step(game, action, 0);
        Mockito.verify(paddle1ControllerSpy, Mockito.times(1)).movePaddle1Down();


    }
}
