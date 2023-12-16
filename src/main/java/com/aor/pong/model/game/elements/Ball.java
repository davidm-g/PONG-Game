package com.aor.pong.model.game.elements;

import com.aor.pong.model.Position;

import java.util.Random;

public class Ball extends Element {
    Random random;
    int xVelocity;
    int yVelocity;
    int initialXSpeed;
    int initialYSpeed;

    public int getInitialXSpeed() {
        return initialXSpeed;
    }

    public int getInitialYSpeed() {
        return initialYSpeed;
    }


    public Ball(int x, int y){
        super(x,y);
        random = new Random();

        initialXSpeed = random.nextInt(2);
        if(initialXSpeed == 0)
            xVelocity = -1;
        else
            xVelocity = initialXSpeed;

        initialYSpeed = random.nextInt(2);
        if(initialYSpeed == 0)
            yVelocity = -1;
        else
            yVelocity = initialYSpeed;

    }

    public void setxVelocity(int randomXDirection) {
        xVelocity = randomXDirection;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int randomYDirection) {
        yVelocity = randomYDirection;
    }

}

