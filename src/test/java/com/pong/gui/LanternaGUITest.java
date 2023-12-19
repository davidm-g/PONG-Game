package com.pong.gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.pong.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.io.IOException;
import java.security.Key;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        LanternaGUI.setMode(0);
    }
    @Test
    void drawBall() {
        gui.drawBall(new Position(60,15));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.ANSI.WHITE);
        Mockito.verify(tg, Mockito.times(1)).putString(60, 15, "\u25CF");
    }

    @Test
    void setMode() {
        int mode = 3;
        LanternaGUI.setMode(mode);
        int expectedPaddleHeight = 3 + 4 * mode;
        int actualPaddleHeight = LanternaGUI.getPaddleHeight();
        assertEquals(expectedPaddleHeight, actualPaddleHeight);
    }

    @Test
    void drawText() {
        gui.drawText(new Position(60, 5), "Menu", "#FFFFFF");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(60, 5, "Menu");
    }

    @Test
    void drawPaddle1() {
        gui.drawPaddle1(new Position(1, 10));
        TerminalPosition top_left = new TerminalPosition(1, 9);
        TerminalSize tsize = new TerminalSize(1, 3);
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(top_left,tsize,new TextCharacter('\u2588', new TextColor.RGB(56,183,254), new TextColor.RGB(18, 18, 18)));
    }

    @Test
    void drawPaddle2() {

        gui.drawPaddle2(new Position(39, 10));
        TerminalPosition top_left = new TerminalPosition(39, 9);
        TerminalSize tsize = new TerminalSize(1, 3);
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(top_left, tsize, new TextCharacter('\u2588', new TextColor.RGB(225,54,54), new TextColor.RGB(18, 18, 18)));
    }


    @Test
    void drawScoreboard() {

        gui.drawScoreBoard(new Position(20, 5),0,0);
        Mockito.verify(tg, Mockito.times(1)).putString(17,2,String.valueOf(0));
        Mockito.verify(tg, Mockito.times(1)).putString(23, 2,String.valueOf(0));

    }
    @Test
    public void testNullInput() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(null);
        assertEquals(GUI.ACTION.NONE,gui.getNextAction());

    }
    @Test
    public void testNull() throws IOException {
        assertEquals(GUI.ACTION.NONE,gui.getNextAction());
    }
    @Test
    public void testQuitAction() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));
        assertEquals(GUI.ACTION.QUIT,gui.getNextAction());
        Mockito.when(screen.pollInput()).thenReturn(KeyStroke.fromString("q"));
        assertEquals(GUI.ACTION.QUIT,gui.getNextAction());

    }
    @Test
    public void testPaddle1Up() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(KeyStroke.fromString("w"));
        assertEquals(GUI.ACTION.PADDLE1UP,gui.getNextAction());

    }
    @Test
    public void testPaddle1Down() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(KeyStroke.fromString("s"));
        assertEquals(GUI.ACTION.PADDLE1DOWN,gui.getNextAction());

    }
    @Test
    public void testPaddle2Down() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
        assertEquals(GUI.ACTION.PADDLE2DOWN,gui.getNextAction());

    }
    @Test
    public void testSelect() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));
        assertEquals(GUI.ACTION.SELECT,gui.getNextAction());

    }
    @Test
    public void testPaddle2UP() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
        assertEquals(GUI.ACTION.PADDLE2UP,gui.getNextAction());

    }
    @Test
    public void testGetPaddleWidth() {
        int expectedpaddlewidth = 1;
        assertEquals(expectedpaddlewidth,LanternaGUI.getPaddleWidth());
    }
    @Test
    public void testClear(){
        gui.clear();
        Mockito.verify(screen,Mockito.times(1)).clear();
    }
    @Test
    public void testRefresh() throws IOException {
        gui.refresh();
        Mockito.verify(screen,Mockito.times(1)).refresh();
    }
    @Test
    public void testClose() throws IOException {
        gui.close();
        Mockito.verify(screen,Mockito.times(1)).close();
    }

    
}