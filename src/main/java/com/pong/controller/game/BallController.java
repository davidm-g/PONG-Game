package com.pong.controller.game;

import com.pong.Game;
import com.pong.controller.MusicManager;
import com.pong.controller.Sounds;
import com.pong.gui.GUI;
import com.pong.model.Position;
import com.pong.model.game.arena.Arena;
import com.pong.model.game.elements.Ball;

import java.io.IOException;
import java.util.Random;

public class BallController extends GameController{
    private long lastMovement;
    public BallController(Arena arena){
        super(arena);
        this.lastMovement = 0;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 50) {
            moveBall(getModel().getBall(), getModel().getBall().getPosition().getDirection(getModel().getBall().getxVelocity(),getModel().getBall().getyVelocity()));
            this.lastMovement = time;
        }
    }
    public void moveBall(Ball ball, Position position) {
        if (getModel().CheckBorderCollision()) {
            MusicManager.getInstance().stopAll();
            MusicManager.getInstance().start(Sounds.HIT);
            ball.setyVelocity(-getModel().getBall().getyVelocity());
        }

        if (getModel().checkColisionPaddles()) {
            MusicManager.getInstance().stopAll();
            MusicManager.getInstance().start(Sounds.PADDLE);
            ball.setxVelocity(-getModel().getBall().getxVelocity());
        }

        if (getModel().checkGoal()) {
            MusicManager.getInstance().stopAll();
            MusicManager.getInstance().start(Sounds.GOAL);
            getModel().getPaddle1().setPosition(new Position(0,getModel().getHeight()/2));
            getModel().getPaddle2().setPosition(new Position(getModel().getWidth() - 1, getModel().getHeight()/2));
            ball.setPosition(new Position(getModel().getWidth()/2,getModel().getHeight()/2));
            Random random = new Random();


            ball.setxVelocity(random.nextInt(2));
            if(ball.getxVelocity() == 0)
                ball.setxVelocity(ball.getxVelocity()-1);

            ball.setyVelocity(random.nextInt(2));
            if(ball.getyVelocity() == 0)
                ball.setyVelocity(ball.getyVelocity() - 1);
        }

    }
}
