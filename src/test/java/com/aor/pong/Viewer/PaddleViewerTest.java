package com.aor.pong.Viewer;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.elements.Paddle;
import com.aor.pong.viewer.game.Paddle1Viewer;
import com.aor.pong.viewer.game.Paddle2Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PaddleViewerTest {
    private Paddle paddle1;
    private Paddle paddle2;
    private Paddle1Viewer viewer1;
    private Paddle2Viewer viewer2;

    private GUI gui;

    @BeforeEach
    void setUp() {
        paddle1 = new Paddle(0, 15);
        paddle2 = new Paddle(120,15);
        viewer1 = new Paddle1Viewer();
        viewer2 = new Paddle2Viewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer1.draw(paddle1, gui);
        viewer2.draw(paddle2,gui);
        Mockito.verify(gui, Mockito.times(1)).drawPaddle1(paddle1.getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawPaddle1(paddle2.getPosition());

    }
}
