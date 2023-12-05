package com.aor.pong.model.game.elements;

import com.aor.pong.model.Position;

import java.util.Random;

public class Ball extends Element {
    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 1;

    public Ball(int x, int y){
        super(x,y);
        random = new Random();
        xVelocity = random.nextInt(2);
        if(xVelocity == 0)
            xVelocity--;
        setxVelocity(xVelocity * initialSpeed);

        yVelocity = random.nextInt(2);
        if(yVelocity == 0)
            yVelocity--;
        setyVelocity(yVelocity * initialSpeed);

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

