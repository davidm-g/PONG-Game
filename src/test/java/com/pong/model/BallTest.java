package com.pong.model;

import com.pong.model.game.elements.Ball;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTest {
    Ball ball;
    @BeforeEach
    public void setup() {
        ball = new Ball(10, 10);
    }

    @Test
    void xVelocity() {
        int ix = ball.getInitialXSpeed();
        if(ix == 0) {
            assertEquals(0,ball.getInitialXSpeed());
            Assertions.assertEquals(-1, ball.getxVelocity());
        }
        else
            Assertions.assertEquals(1, ball.getxVelocity());
        ball.setxVelocity(2);
        Assertions.assertEquals(2, ball.getxVelocity());
    }

    @Test
    void yVelocity() {
        int iy = ball.getInitialYSpeed();
        if(iy == 0) {
            assertEquals(0,ball.getInitialYSpeed());
            Assertions.assertEquals(-1, ball.getyVelocity());
        }
        else
            Assertions.assertEquals(1, ball.getyVelocity());
        ball.setyVelocity(2);
        Assertions.assertEquals(2, ball.getyVelocity());
    }
}
