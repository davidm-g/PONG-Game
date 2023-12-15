package com.aor.pong.viewer.game;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.elements.ScoreBoard;

public class ScoreBoardViewer implements ElementViewer<ScoreBoard>{
    @Override
    public void draw(ScoreBoard scoreboard, GUI gui) {
        gui.drawScoreBoard(scoreboard.getPosition(),scoreboard.getScore1(),scoreboard.getScore2(),
                scoreboard.getName1(), scoreboard.getName2());
    }
}
