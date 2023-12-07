package com.aor.pong.viewer.menu;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(18, 3), "Menu", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if(i==0)
            gui.drawText(
                    new Position(5, 8 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#38b7fe" : "#FFFFFF");
            else if(i==1)
                gui.drawText(
                        new Position(5, 10 + i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#fe3031" : "#FFFFFF");
        }

    }
}
