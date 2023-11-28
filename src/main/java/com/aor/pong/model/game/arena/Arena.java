package com.aor.pong.model.game.arena;

import com.aor.pong.gui.LanternaGUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.game.elements.ScoreBoard;
import com.aor.pong.model.game.elements.Ball;
import com.aor.pong.model.game.elements.Paddle;

public class Arena {
    private final int width;
    private final int height;
    private Paddle paddle1;
    private Paddle paddle2;
    private Ball ball;
    private ScoreBoard scoreBoard;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle1() {
        return paddle1;
    }

    public Paddle getPaddle2() {
        return paddle2;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setPaddle1(Paddle paddle1) {
        this.paddle1 = paddle1;
    }

    public void setPaddle2(Paddle paddle2) {
        this.paddle2 = paddle2;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
    public boolean CheckPos(Position position){
        if(position.getY() < this.height && position.getY() > 0) return true;
        return false;
    }
    public boolean CheckPosPaddle(Position position) {
        if(position.getY() < this.height - LanternaGUI.getPaddleHeight()/2 + 2 && position.getY() > LanternaGUI.getPaddleHeight()/2 - 1) return true;
        return false;
    }

}
