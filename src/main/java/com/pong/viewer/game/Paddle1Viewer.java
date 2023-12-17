package com.pong.viewer.game;

import com.pong.gui.GUI;
import com.pong.model.game.elements.Paddle;

public class Paddle1Viewer implements ElementViewer<Paddle> {
    @Override
    public void draw(Paddle paddle1, GUI gui) { gui.drawPaddle1(paddle1.getPosition()); }

}
