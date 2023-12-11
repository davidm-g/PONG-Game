package com.aor.pong.viewer.Winner;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.Winner.Winner;
import com.aor.pong.viewer.Viewer;

public class WinnerViewer extends Viewer<Winner> {
    public WinnerViewer(Winner winner) {
        super(winner);
    }
    public void drawSymbol(GUI gui) {

        String s1 = "   _________    __  _________";
        String s2 = "  / ____/   |  /  |/  / ____/";
        String s3 = " / / __/ /| | / /|_/ / __/";
        String s4 = "/ /_/ / ___ |/ /  / / /___";
        String s5 = "\\____/_/  |_/_/  /_/_____/";

        String s6 = "   ____ _    ____________";
        String s7 = "  / __ \\ |  / / ____/ __ \\";
        String s8 = " / / / / | / / __/ / /_/ /";
        String s9 = "/ /_/ /| |/ / /___/ _, _/";
        String s10 = "\\____/ |___/_____/_/ |_|";

        gui.drawText(new Position(5, 1), s1, "#FFB852");
        gui.drawText(new Position(5, 2), s2, "#FFB852");
        gui.drawText(new Position(5, 3), s3, "#FFB852");
        gui.drawText(new Position(5, 4), s4, "#FFB852");
        gui.drawText(new Position(5, 5), s5, "#FFB852");

        gui.drawText(new Position(5, 6), s6, "#FFB852");
        gui.drawText(new Position(5, 7), s7, "#FFB852");
        gui.drawText(new Position(5, 8), s8, "#FFB852");
        gui.drawText(new Position(5, 9), s9, "#FFB852");
        gui.drawText(new Position(5, 10), s10, "#FFB852");
    }

    @Override
    public void drawElements(GUI gui) {
        drawSymbol(gui);
        gui.drawText(new Position(9, 12), "PLAYER"+ String.valueOf(getModel().getPlaynumber()) + " IS THE WINNER!", "#DAA520");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if(i==0)
                gui.drawText(
                        new Position(14, 14 + i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#38b7fe" : "#FFFFFF");
            else if(i==1)
                gui.drawText(
                        new Position(12, 16 + i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#fe3031" : "#FFFFFF");
        }

    }


}
