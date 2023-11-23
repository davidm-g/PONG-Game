package com.aor.pong.gui;

import com.aor.pong.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPaddle1(Position position);

    void drawPaddle2(Position position);

    void drawWall(Position position);

    void drawBall(Position position);

    void drawScoreBoard(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, DOWN, NONE, QUIT, SELECT}
}