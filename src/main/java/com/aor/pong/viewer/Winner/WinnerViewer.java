package com.aor.pong.viewer.Winner;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.Winner.Winner;
import com.aor.pong.viewer.Viewer;

public class WinnerViewer extends Viewer<Winner> {
    public WinnerViewer(Winner winner){super(winner);}

    @Override
    public void drawElements(GUI gui) {

        gui.drawText(new Position(9, 4), "PLAYER"+ String.valueOf(getModel().getPlaynumber()) + " IS THE WINNER!", "#DAA520");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if(i==0)
                gui.drawText(
                        new Position(14, 10 + i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#38b7fe" : "#FFFFFF");
            else if(i==1)
                gui.drawText(
                        new Position(12, 12 + i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#fe3031" : "#FFFFFF");
        }

    }


}
