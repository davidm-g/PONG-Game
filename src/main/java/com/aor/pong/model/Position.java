package com.aor.pong.model;

public class Position {
    int x;
    int y;
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

}