package com.aor.pong.model;

import com.aor.pong.model.game.elements.ScoreBoard;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {
    ScoreBoard scoreBoard;
    @BeforeEach
    public void setup() {
         scoreBoard = new ScoreBoard(10, 10);
    }

    @Test
    void player1Score(){
        int initial = scoreBoard.getScore1();
        scoreBoard.alterScore1();
        assertEquals(initial + 1, scoreBoard.getScore1());
    }

    @Test
    void player2Score(){
        int initial = scoreBoard.getScore1();
        scoreBoard.alterScore2();
        assertEquals(initial + 1, scoreBoard.getScore2());
    }
}
