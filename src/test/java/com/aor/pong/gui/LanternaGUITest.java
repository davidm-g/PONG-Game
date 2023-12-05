package com.aor.pong.gui;

import com.aor.pong.model.Position;
import com.aor.pong.model.game.elements.Ball;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen);
    }
    @Test
    void drawBall() {
        gui.drawBall(new Position(1,1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.ANSI.WHITE);
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "\u25CF");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(60, 5), "Menu", "#FFFFFF");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(60, 5, "Menu");
    }

    @Test
    void drawPaddle1() {
        gui.drawPaddle1(new Position(0, 15));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 0, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(0, 15, "\u2588");
    }

    @Test
    void drawPaddle2() {
        gui.drawPaddle2(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "H");
    }


    @Test
    void drawScoreboard() {
        gui.drawScoreBoard(new Position(60, 5),0,0);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "H");
    }
}