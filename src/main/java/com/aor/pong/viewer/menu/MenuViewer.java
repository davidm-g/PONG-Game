package com.aor.pong.viewer.menu;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    public void drawSymbol(GUI gui) {
        String s1 = "    ____  ____  _   ________";
        String s2 = "   / __ \\/ __ \\/ | / / ____/";
        String s3 = "  / /_/ / / / /  |/ / /";
        String s4 = " / ____/ /_/ / /|  / /_/ /";
        String s5 = "/_/    \\____/_/ |_/\\____/";

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
            if(i==0)
            gui.drawText(
                    new Position(5, 11 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#38b7fe" : "#FFFFFF");
            else if(i==1)
                gui.drawText(
                        new Position(5, 13 + i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#fe3031" : "#FFFFFF");
        }

    }
}
