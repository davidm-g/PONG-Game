package com.pong.viewer.game;

import com.pong.gui.GUI;
import com.pong.model.game.elements.ScoreBoard;

public class ScoreBoardViewer implements ElementViewer<ScoreBoard>{
    @Override
    public void draw(ScoreBoard scoreboard, GUI gui) {
        gui.drawScoreBoard(scoreboard.getPosition(),scoreboard.getScore1(),scoreboard.getScore2());
    }
}
