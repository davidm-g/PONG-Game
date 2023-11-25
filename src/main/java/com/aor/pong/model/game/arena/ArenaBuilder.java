package com.aor.pong.model.game.arena;

import com.aor.pong.model.game.elements.Paddle;
import com.aor.pong.model.game.elements.Ball;
import com.aor.pong.model.game.elements.ScoreBoard;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setPaddle1(createPaddle1());
        arena.setPaddle2(createPaddle2());
        arena.setBall(createBall());
        arena.setScoreBoard(createScoreBoard());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract Ball createBall();

    protected abstract ScoreBoard createScoreBoard();

    protected abstract Paddle createPaddle1();

    protected abstract Paddle createPaddle2();
}
