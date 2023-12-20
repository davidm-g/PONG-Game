package com.pong.Controller;

import com.pong.Game;
import com.pong.controller.game.BallController;
import com.pong.gui.GUI;
import com.pong.model.Position;
import com.pong.model.game.arena.Arena;
import com.pong.model.game.elements.Ball;
import com.pong.model.game.elements.Paddle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class BallControllerTest {
    private Arena arena;
    private Game game;

    @BeforeEach
    public void setUp(){
        arena= Mockito.mock(Arena.class);
        game= Mockito.mock(Game.class);
    }

    @Test
    public void testStep() throws IOException {
        BallController ballController=new BallController(arena);
        Ball ball= Mockito.mock(Ball.class);
        Mockito.when(arena.getBall()).thenReturn(ball);
        Mockito.when(ball.getPosition()).thenReturn(new Position(20,10));
        Paddle paddle1=Mockito.mock(Paddle.class);
        Mockito.when(arena.getPaddle1()).thenReturn(paddle1);
        Paddle paddle2=Mockito.mock(Paddle.class);
        Mockito.when(arena.getPaddle2()).thenReturn(paddle2);
        Mockito.when(arena.checkGoal()).thenReturn(true);
        Mockito.when(arena.checkColisionPaddles()).thenReturn(true);
        Mockito.when(arena.CheckBorderCollision()).thenReturn(true);
        long currentTime=100;
        ballController.step(game, GUI.ACTION.NONE,currentTime);
        Mockito.verify(arena,Mockito.times(1)).CheckBorderCollision();
        Mockito.verify(arena,Mockito.times(1)).checkColisionPaddles();
        Mockito.verify(arena,Mockito.times(1)).checkGoal();


    }
    @Test
    public void testMoveBall(){
        BallController ballController=new BallController(arena);
        Ball ball= Mockito.mock(Ball.class);
        Mockito.when(arena.getBall()).thenReturn(ball);
        Mockito.when(ball.getPosition()).thenReturn(new Position(20,10));
        Mockito.when(arena.checkGoal()).thenReturn(true);
        Mockito.when(arena.checkColisionPaddles()).thenReturn(true);
        Mockito.when(arena.CheckBorderCollision()).thenReturn(true);
        Paddle paddle1=Mockito.mock(Paddle.class);
        Mockito.when(arena.getPaddle1()).thenReturn(paddle1);
        Paddle paddle2=Mockito.mock(Paddle.class);
        Mockito.when(arena.getPaddle2()).thenReturn(paddle2);
        ballController.moveBall(ball,new Position(19,9));
        Mockito.verify(arena,Mockito.times(1)).CheckBorderCollision();
        Mockito.verify(arena,Mockito.times(1)).checkColisionPaddles();
        Mockito.verify(arena,Mockito.times(1)).checkGoal();
        Mockito.verify(ball,Mockito.times(3)).setyVelocity(Mockito.anyInt());
        Mockito.verify(ball,Mockito.times(3)).setxVelocity(Mockito.anyInt());
    }
}