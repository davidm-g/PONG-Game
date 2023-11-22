package com.aor.hero;

public abstract class Element {
    Position position;
    public Element(int x, int y){this.position = new Position(x,y);}

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
