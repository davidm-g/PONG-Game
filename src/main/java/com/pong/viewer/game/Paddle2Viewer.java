package com.pong.viewer.game;

import com.pong.gui.GUI;
import com.pong.model.game.elements.Paddle;

public class Paddle2Viewer implements ElementViewer<Paddle> {
    public void draw(Paddle paddle2, GUI gui) { gui.drawPaddle2(paddle2.getPosition()); }


}
