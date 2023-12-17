package com.pong.Viewer;

import com.pong.gui.GUI;
import com.pong.model.game.elements.ScoreBoard;
import com.pong.viewer.game.ScoreBoardViewer;
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
