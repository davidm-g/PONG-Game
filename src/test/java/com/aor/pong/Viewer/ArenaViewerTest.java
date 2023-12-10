package com.aor.pong.Viewer;

import com.aor.pong.gui.GUI;
import com.aor.pong.gui.LanternaGUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.model.game.arena.ArenaBuilder;
import com.aor.pong.model.game.elements.Ball;
import com.aor.pong.model.game.elements.Paddle;
import com.aor.pong.model.game.elements.ScoreBoard;
import com.aor.pong.viewer.game.BallViewer;
import com.aor.pong.viewer.game.GameViewer;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class ArenaViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(40, 20);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);
        arena.setScoreBoard(new ScoreBoard(20,5));
        arena.setBall(new Ball(20,10));
        arena.setPaddle1(new Paddle(0, 10));
        arena.setPaddle2(new Paddle(40,10));

    }

    @Test
    void drawBall() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBall(arena.getBall().getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawBall(Mockito.any(Position.class));

    }

    @Test
    void drawPaddle1() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPaddle1(arena.getPaddle1().getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawPaddle1(Mockito.any(Position.class));
    }
    @Test
    void drawPaddle2() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui,Mockito.times(1)).drawPaddle2(arena.getPaddle2().getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawPaddle1(Mockito.any(Position.class));

    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
