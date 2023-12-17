package com.pong.viewer.mode;

import com.pong.gui.GUI;
import com.pong.model.Position;
import com.pong.model.mode.Mode;
import com.pong.viewer.Viewer;

public class ModeViewer extends Viewer<Mode> {
    public ModeViewer(Mode mode) {
        super(mode);
    }

    public void drawSymbol(GUI gui) {
        String s1 = "    __  _______  ____  ______";
        String s2 = "   /  |/  / __ \\/ __ \\/ ____/";
        String s3 = "  / /|_/ / / / / / / / __/";
        String s4 = " / /  / / /_/ / /_/ / /___";
        String s5 = "/_/  /_/\\____/_____/_____/";

        gui.drawText(new Position(5, 3), s1, "#FFB852");
        gui.drawText(new Position(5, 4), s2, "#FFB852");
        gui.drawText(new Position(5, 5), s3, "#FFB852");
        gui.drawText(new Position(5, 6), s4, "#FFB852");
        gui.drawText(new Position(5, 7), s5, "#FFB852");
    }

    @Override
    public void drawElements(GUI gui) {
        drawSymbol(gui);
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(5, 11 + i*2),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#38b7fe" : "#FFFFFF");
        }

    }
}
