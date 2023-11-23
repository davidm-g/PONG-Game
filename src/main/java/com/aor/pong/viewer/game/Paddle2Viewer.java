package com.aor.pong.viewer.game;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.elements.Paddle;

public class Paddle2Viewer implements ElementViewer<Paddle>{
    @Override
    public void draw(Paddle paddle2, GUI gui) { gui.drawPaddle2(paddle2.getPosition()); }
}
