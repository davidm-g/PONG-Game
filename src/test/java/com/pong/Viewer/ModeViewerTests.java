package com.pong.Viewer;

import com.pong.gui.GUI;
import com.pong.model.Position;
import com.pong.model.mode.Mode;
import com.pong.viewer.mode.ModeViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ModeViewerTests {
    @Test
    public void testDrawSymbol(){

        GUI guimock = Mockito.mock(GUI.class);

        ModeViewer modeViewer = new ModeViewer(new Mode());

        modeViewer.drawSymbol(guimock);

        Mockito.verify(guimock).drawText(new Position(5,3),"    __  _______  ____  ______","#FFB852");
        Mockito.verify(guimock).drawText(new Position(5,4),"   /  |/  / __ \\/ __ \\/ ____/","#FFB852");
        Mockito.verify(guimock).drawText(new Position(5,5),"  / /|_/ / / / / / / / __/","#FFB852");
        Mockito.verify(guimock).drawText(new Position(5,6)," / /  / / /_/ / /_/ / /___","#FFB852");
        Mockito.verify(guimock).drawText(new Position(5,7),"/_/  /_/\\____/_____/_____/","#FFB852");

    }

    @Test
    public void testDrawElements(){
        GUI guimock = Mockito.mock(GUI.class);
        Mode modeStub = Mockito.mock(Mode.class);

        Mockito.when(modeStub.getNumberEntries()).thenReturn(3);
        Mockito.when(modeStub.getEntry(0)).thenReturn("Easy");
        Mockito.when(modeStub.getEntry(1)).thenReturn("Medium");
        Mockito.when(modeStub.getEntry(2)).thenReturn("Hard");
        Mockito.when(modeStub.isSelected(0)).thenReturn(false);
        Mockito.when(modeStub.isSelected(1)).thenReturn(false);
        Mockito.when(modeStub.isSelected(2)).thenReturn(true);

        ModeViewer modeViewer = new ModeViewer(modeStub);

        modeViewer.drawElements(guimock);

        modeViewer.drawSymbol(guimock);


        Mockito.verify(guimock).drawText(new Position(5,11),"Easy","#FFFFFF");
        Mockito.verify(guimock).drawText(new Position(5,13),"Medium","#FFFFFF");
        Mockito.verify(guimock).drawText(new Position(5,15),"Hard","#38b7fe");


    }

}
