package com.aor.pong.model.game.elements;

import com.aor.pong.model.Position;

import java.util.Random;

public class Ball extends Element {
    Random random;
    int xVelocity;
    int yVelocity;

    public Ball(int x, int y){
        super(x,y);
        random = new Random();
        this.xVelocity = random.nextInt(2);
        if(xVelocity == 0)
            xVelocity--;


        this.yVelocity = random.nextInt(2);
        if(yVelocity == 0)
            yVelocity--;

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

