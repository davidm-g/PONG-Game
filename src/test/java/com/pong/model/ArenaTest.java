package com.pong.model;

import com.pong.gui.LanternaGUI;
import com.pong.model.game.arena.Arena;
import com.pong.model.game.elements.Ball;
import com.pong.model.game.elements.Paddle;
import com.pong.model.game.elements.ScoreBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    private Arena arena;
    private Paddle paddle1;
    private Paddle paddle2;
    private Ball ball;

    @BeforeEach
    public void setup(){
        arena = new Arena(40,20);
        paddle1 = new Paddle(0,10);
        paddle2 = new Paddle(40,10);
        ball = new Ball(40,20);
    }
    @Test
    public void testGetWidthandHeight(){
        assertEquals(40,arena.getWidth());
        assertEquals(20,arena.getHeight());
    }
    @Test
    public void testSetandGetPaddle(){
        arena.setPaddle1(paddle1);
        arena.setPaddle2(paddle2);
        assertEquals(paddle1,arena.getPaddle1());
        assertEquals(paddle2,arena.getPaddle2());
    }
    @Test
    public void testSetandGetBall(){
        Ball ball  = new Ball(20,10);
        arena.setBall(ball);
        assertEquals(ball,arena.getBall());
    }
    @Test
    public void testSetandGetScoreBoard(){
        ScoreBoard scoreBoard = new ScoreBoard(20,5);
        arena.setScoreBoard(scoreBoard);
        assertEquals(scoreBoard,arena.getScoreBoard());

    }
    @Test
    public void testCheckPosPaddle() {
        Position onLowerBoundary = new Position(10, arena.getHeight() - LanternaGUI.getPaddleHeight() / 2 + 1);
        Position justOutsideLowerBoundary = new Position(10, arena.getHeight() - LanternaGUI.getPaddleHeight() / 2 + 2);
        Position onUpperBoundary = new Position(10, LanternaGUI.getPaddleHeight() / 2);
        Position justOutsideUpperBoundary = new Position(10, LanternaGUI.getPaddleHeight() / 2 - 1);

        assertTrue(arena.CheckPosPaddle(onUpperBoundary));
        assertFalse(arena.CheckPosPaddle(justOutsideUpperBoundary));
        assertTrue(arena.CheckPosPaddle(onLowerBoundary));
        assertFalse(arena.CheckPosPaddle(justOutsideLowerBoundary));
    }

    @Test
    public void testCheckBorderCollision() {
        ball.setPosition(new Position(5, 0));
        arena.setBall(ball);
        assertTrue(arena.CheckBorderCollision());

        ball.setPosition(new Position(5, arena.getHeight()));
        arena.setBall(ball);
        assertTrue(arena.CheckBorderCollision());

        ball.setPosition(new Position(5, 1));
        arena.setBall(ball);
        assertFalse(arena.CheckBorderCollision());

        ball.setPosition(new Position(5, arena.getHeight() - 1));
        arena.setBall(ball);
        assertFalse(arena.CheckBorderCollision());
    }

    @Test
    public void testCheckCollisionPaddles() {
        ball.setPosition(new Position(LanternaGUI.getPaddleWidth(), 10));
        arena.setBall(ball);
        paddle1.setPosition(new Position(LanternaGUI.getPaddleWidth(), 10));
        arena.setPaddle1(paddle1);
        assertTrue(arena.checkColisionPaddles());

        ball.setPosition(new Position(arena.getWidth() - LanternaGUI.getPaddleWidth(), 10));
        arena.setBall(ball);
        paddle2.setPosition(new Position(arena.getWidth() - LanternaGUI.getPaddleWidth(), 10));
        arena.setPaddle2(paddle2);
        assertTrue(arena.checkColisionPaddles());

        ball.setPosition(new Position(LanternaGUI.getPaddleWidth() + 1, 10));
        arena.setBall(ball);
        paddle1.setPosition(new Position(0, 10));
        arena.setPaddle1(paddle1);
        assertFalse(arena.checkColisionPaddles());

        ball.setPosition(new Position(arena.getWidth() - LanternaGUI.getPaddleWidth() - 2, 10));
        arena.setBall(ball);
        paddle2.setPosition(new Position(arena.getWidth(), 10));
        arena.setPaddle2(paddle2);
        assertFalse(arena.checkColisionPaddles());
    }
    @Test
    public void testCheckGoal(){
        Ball ball = new Ball(0,10);
        Ball ball1 = new Ball(40,10);
        ScoreBoard scoreBoard = new ScoreBoard(20,5);
        arena.setBall(ball);
        arena.setScoreBoard(scoreBoard);

        ScoreBoard scoreBoard1 = new ScoreBoard(20,5);
        arena.setBall(ball1);
        arena.setScoreBoard(scoreBoard1);
        assertTrue(arena.checkGoal());
    }
}
