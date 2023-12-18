package com.pong.model;

import com.pong.model.game.arena.Arena;
import com.pong.model.game.arena.ArenaBuilder;
import com.pong.model.game.elements.Ball;
import com.pong.model.game.elements.Paddle;
import com.pong.model.game.elements.ScoreBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArenaBuilderTest {
    private ArenaBuilder arenaBuilder;
    @BeforeEach
    public void setup(){
        arenaBuilder = new ArenaBuilder();
    }
    @Test
    public void testCreateArena(){
        Arena arena = arenaBuilder.createArena();

        assertNotNull(arena);
        assertEquals(40,arena.getWidth());
        assertEquals(20, arena.getHeight());
        assertEquals(arena.getBall().getPosition(),new Position(arena.getWidth()/2, arena.getHeight()/2));
        assertEquals(arena.getPaddle1().getPosition(),new Position(0, arena.getHeight()/2));
        assertEquals(arena.getPaddle2().getPosition(),new Position(arena.getWidth(), arena.getHeight()/2));
        assertEquals(arena.getScoreBoard().getPosition(),new Position(arena.getWidth()/2, 5));

    }

    @Test
    public void testCreateBall(){
        Ball ball = arenaBuilder.createBall(20,10);

        assertNotNull(ball);
        assertEquals(20,ball.getPosition().getX());
        assertEquals(10,ball.getPosition().getY());

    }

    @Test
    public void testCreateScoreBoard(){
        ScoreBoard scoreBoard = arenaBuilder.createScoreBoard(20,5);

        assertNotNull(scoreBoard);
        assertEquals(20,scoreBoard.getPosition().getX());
        assertEquals(5,scoreBoard.getPosition().getY());
    }

    @Test
    public void testCreatePaddle1(){
        Paddle paddle1 = arenaBuilder.createPaddle1(0,10);

        assertNotNull(paddle1);
        assertEquals(0,paddle1.getPosition().getX());
        assertEquals(10,paddle1.getPosition().getY());
    }

    @Test
    public void testCreatePaddle2(){
        Paddle paddle2 = arenaBuilder.createPaddle2(40,10);

        assertNotNull(paddle2);
        assertEquals(40,paddle2.getPosition().getX());
        assertEquals(10,paddle2.getPosition().getY());
    }
}
