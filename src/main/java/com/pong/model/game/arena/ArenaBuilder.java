package com.pong.model.game.arena;

import com.pong.model.game.elements.Paddle;
import com.pong.model.game.elements.Ball;
import com.pong.model.game.elements.ScoreBoard;

public class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(40, 20);

        arena.setPaddle1(createPaddle1(0,arena.getHeight()/2));
        arena.setPaddle2(createPaddle2(arena.getWidth() - 1, arena.getHeight()/2));
        arena.setBall(createBall(arena.getWidth()/2,arena.getHeight()/2));
        arena.setScoreBoard(createScoreBoard(arena.getWidth() / 2, 5));

        return arena;
    }


    public Ball createBall(int x, int y){
        return new Ball(x,y);
    }

    public ScoreBoard createScoreBoard(int x, int y){
        return new ScoreBoard(x,y);
    }

    public Paddle createPaddle1(int x, int y){
        return new Paddle(x,y);
    }

    public Paddle createPaddle2(int x, int y){
        return new Paddle(x,y);
    }
}
