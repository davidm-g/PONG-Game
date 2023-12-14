package com.aor.pong.model;


import java.util.Objects;

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
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(!(obj instanceof Position)) return false;
        Position position =(Position) obj;
        return x== position.x && y== position.y;
    }
    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
}
