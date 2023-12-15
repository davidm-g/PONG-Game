package com.aor.pong.gui;

import com.aor.pong.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;
    static final int PADDLE_WIDTH = 1;
    private static int PADDLE_HEIGHT;
    TextColor PADDLE1_COLOR = new TextColor.RGB(56,183,254);
    TextColor PADDLE2_COLOR = new TextColor.RGB(225,54,54);
    TextColor BACKGROUND = new TextColor.RGB(18, 18, 18);
    int terminal_width, terminal_height;
    TextGraphics textGraphics;
    Terminal terminal;
    private Font font;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
        this.textGraphics = screen.newTextGraphics();
    }

    public static void setMode(int mode) {
        PADDLE_HEIGHT = 4 + 3*mode;
    }

    public static int getPaddleHeight() {
        return PADDLE_HEIGHT;
    }

    public static int getPaddleWidth() { return PADDLE_WIDTH; }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        this.terminal = createTerminal(width, height, fontConfig);
        this.terminal_width = width;
        this.terminal_height = height;
        this.screen = createScreen(terminal);
        this.textGraphics = screen.newTextGraphics();
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }


    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'w') return ACTION.PADDLE1UP;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 's') return ACTION.PADDLE1DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.PADDLE2UP;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.PADDLE2DOWN;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawPaddle1(Position position) {
        TerminalPosition top_left = new TerminalPosition(position.getX() - PADDLE_WIDTH + 1, position.getY() - PADDLE_HEIGHT/2);
        int width = PADDLE_WIDTH;
        int height = PADDLE_HEIGHT;
        TerminalSize tsize = new TerminalSize(width, height);
        textGraphics.fillRectangle(top_left, tsize, new TextCharacter('\u2588', PADDLE1_COLOR, BACKGROUND));
    }


    @Override
    public void drawPaddle2(Position position) {
        TerminalPosition top_left = new TerminalPosition(position.getX() - PADDLE_WIDTH/2 - 1, position.getY() - PADDLE_HEIGHT/2);
        int width = PADDLE_WIDTH;
        int height = PADDLE_HEIGHT;
        TerminalSize tsize = new TerminalSize(width, height);
        textGraphics.fillRectangle(top_left, tsize, new TextCharacter('\u2588', PADDLE2_COLOR, BACKGROUND));
    }

    @Override
    public void drawBall(Position position) {

        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(BACKGROUND);
        textGraphics.putString(position.getX(), position.getY(), "\u25CF");

    }


    @Override
    public void drawScoreBoard(Position position, int score1, int score2, String name1, String name2) {
        textGraphics.putString(position.getX() - 3, 1, String.valueOf(score1));
        textGraphics.putString(position.getX() + 3, 1, String.valueOf(score2));
        textGraphics.drawLine(0, 3, terminal_width, 3, '\u2588');
        textGraphics.putString(position.getX() - name1.length() - 7, 1, name1);
        textGraphics.putString(position.getX() + 8, 1, name2);
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }


    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
