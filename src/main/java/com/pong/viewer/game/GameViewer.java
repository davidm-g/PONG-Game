package com.pong.viewer.game;

import com.pong.gui.GUI;
import com.pong.model.game.arena.Arena;
import com.pong.model.game.elements.Element;
import com.pong.viewer.Viewer;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElement(gui, getModel().getBall(), new BallViewer());
        drawElement(gui, getModel().getPaddle1(), new Paddle1Viewer());
        drawElement(gui, getModel().getPaddle2(), new Paddle2Viewer());
        drawElement(gui, getModel().getScoreBoard(), new ScoreBoardViewer());
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
