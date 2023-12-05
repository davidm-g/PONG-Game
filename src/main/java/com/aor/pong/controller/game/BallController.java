package com.aor.pong.controller.game;

import com.aor.pong.Game;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.model.game.elements.Ball;

import java.io.IOException;

public class BallController extends GameController{
    private long lastMovement;
    public BallController(Arena arena){
        super(arena);
        this.lastMovement = 0;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 100) {
            moveBall(getModel().getBall(), getModel().getBall().getPosition().getDirection(getModel().getBall().getxVelocity(),getModel().getBall().getyVelocity()));
            this.lastMovement = time;
        }
    }
    public void moveBall(Ball ball, Position position) {
        /*
        if (getModel().checkGoal()) {

        }

         */
        if (getModel().checkColisionPaddles()) {
            if (getModel().getBall().getxVelocity() < 0) {
                getModel().getBall().setyVelocity(-getModel().getBall().getyVelocity() + 1);
            }
            else if (getModel().getBall().getxVelocity() > 0) {
                getModel().getBall().setxVelocity(-getModel().getBall().getxVelocity() - 1);
            }
            if(getModel().getBall().getyVelocity() < 0) {
                getModel().getBall().setyVelocity(-getModel().getBall().getyVelocity() + 1);
            }
            else if(getModel().getBall().getyVelocity() > 0)
                getModel().getBall().setyVelocity(-getModel().getBall().getyVelocity() - 1);
        }

        if (getModel().CheckBorderCollision()) {
            getModel().getBall().setyVelocity(-getModel().getBall().getyVelocity());
        }
        getModel().getBall().setPosition(position);
    }

}
