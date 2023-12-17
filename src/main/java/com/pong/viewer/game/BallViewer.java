package com.pong.viewer.game;

import com.pong.gui.GUI;
import com.pong.model.game.elements.Ball;

public class BallViewer implements ElementViewer<Ball> {
    @Override
    public void draw(Ball ball, GUI gui) {
        gui.drawBall(ball.getPosition());
    }
}
