package com.aor.pong.Controller;

import com.aor.pong.controller.game.Paddle1Controller;
import com.aor.pong.model.Position;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.model.game.elements.Paddle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Paddle2ControllerTest {
    private Paddle1Controller controller;
    private Paddle paddle1;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(40, 20);

        paddle1 = new Paddle(0, 10);
        arena.setPaddle1(paddle1);

        controller = new Paddle1Controller(arena);
    }

    @Test
    void movePaddle1UP() {
        controller.movePaddle1Up();
        Position position = new Position(0,9);
        assert(position.getY() == paddle1.getPosition().getY());
    }

    @Test
    void movePaddle1DOWN() {

        controller.movePaddle1Down();
        Position position = new Position(0,11);
        assert(position.getY() == paddle1.getPosition().getY());
    }
}
