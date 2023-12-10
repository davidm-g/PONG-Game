package com.aor.pong.Viewer;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.elements.Paddle;
import com.aor.pong.model.game.elements.ScoreBoard;
import com.aor.pong.viewer.game.Paddle1Viewer;
import com.aor.pong.viewer.game.Paddle2Viewer;
import com.aor.pong.viewer.game.ScoreBoardViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ScoreBoardViewerTest {
    private ScoreBoard scoreBoard;

    private ScoreBoardViewer viewer;


    private GUI gui;

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard(20,5);
        viewer = new ScoreBoardViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(scoreBoard, gui);
        Mockito.verify(gui, Mockito.times(1)).drawScoreBoard(scoreBoard.getPosition(),scoreBoard.getScore1(),scoreBoard.getScore2());
    }
}
