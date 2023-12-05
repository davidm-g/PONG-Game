package com.aor.pong.model;


public class Position {
    int x;
    int y;
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Position getUp() {
        return new Position(x, y - 1);
    }

    public Position getDown() {
        return new Position(x, y + 1);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public Position getDirection(int xv, int yv){
        return new Position(x += xv, y += yv);
    }
}
