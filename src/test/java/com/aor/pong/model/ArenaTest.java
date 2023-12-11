package com.aor.pong.model;

import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.model.game.elements.Ball;
import com.aor.pong.model.game.elements.Paddle;
import com.aor.pong.model.game.elements.ScoreBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    private Arena arena;
    private Paddle paddle1;
    private Paddle paddle2;

    @BeforeEach
    public void setup(){
        arena = new Arena(40,20);
        paddle1 = new Paddle(0,10);
        paddle2 = new Paddle(40,10);
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
    public void testCheckPosPaddle(){
        assertTrue(arena.CheckPosPaddle(new Position(0,10)));
        assertFalse(arena.CheckPosPaddle(new Position(0,40)));
    }
    @Test
    public void testBorderColison(){
        Ball ball = new Ball(10,0);
        arena.setBall(ball);
        assertTrue(arena.CheckBorderCollision());
    }
    @Test
    public void testCheckColsionPaddles(){
        Ball ball = new Ball(0,10);
        arena.setBall(ball);
        arena.setPaddle1(paddle1);

        assertTrue(arena.checkColisionPaddles());

        Ball ball1 = new Ball(40,10);
        arena.setBall(ball1);
        arena.setPaddle2(paddle2);
        assertTrue(arena.checkColisionPaddles());
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
