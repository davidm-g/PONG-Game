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
    public boolean CheckBorderCollision() {

        //bounce ball off top & bottom window edges
        if (ball.getPosition().getY() <= 1 || ball.getPosition().getY() >= height - 1) {
            return true;
        }
        return false;
    }
        //bounce ball off paddles
    public boolean checkColisionPaddles() {
        if (ball.getPosition().getX() <= LanternaGUI.getPaddleWidth() && // PADDLE 1
                ball.getPosition().getY() <= paddle1.getPosition().getY() + LanternaGUI.getPaddleHeight() / 2 &&
                ball.getPosition().getY() >= paddle1.getPosition().getY() - LanternaGUI.getPaddleHeight() / 2) {
            return true;
        }
        else if (ball.getPosition().getX() >= width - LanternaGUI.getPaddleWidth() && // PADDLE 2
                ball.getPosition().getY() <= paddle1.getPosition().getY() + LanternaGUI.getPaddleHeight() / 2 &&
                ball.getPosition().getY() >= paddle1.getPosition().getY() - LanternaGUI.getPaddleHeight() / 2) {
            return true;
        }
        return false;
    }
    /*
            ball.setxVelocity(Math.abs(ball.getxVelocity()));
            ball.setxVelocity(ball.getxVelocity()+1); //optional for more difficulty
            if (ball.yVelocity > 0)
                ball.yVelocity++; //optional for more difficulty
            else
                ball.yVelocity--;
            ball.setxVelocity(ball.xVelocity);
            ball.setyVelocity(ball.yVelocity);

        if (ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //optional for more difficulty
            if (ball.yVelocity > 0)
                ball.yVelocity++; //optional for more difficulty
            else
                ball.yVelocity--;
            ball.setxVelocity(-ball.xVelocity);
            ball.setyVelocity(ball.yVelocity);
        }
    public boolean checkGoal(){
    //stops paddles at window edges
    if(paddle1.y<=0)
        paddle1.y=0;
    if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
        paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
    if(paddle2.y<=0)
        paddle2.y=0;
    if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
        paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
    //give a player 1 point and creates new paddles & ball
    if(ball.x <=0) {
        score.player2++;
        newPaddles();
        newBall();
        System.out.println("Player 2: "+score.player2);
    }
    if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
        score.player1++;
        newPaddles();
        newBall();
        System.out.println("Player 1: "+score.player1);
    }
    }

     */
}
