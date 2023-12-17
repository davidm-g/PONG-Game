package com.pong.Viewer;

import com.pong.gui.GUI;
import com.pong.model.Position;
import com.pong.model.Winner.Winner;
import com.pong.viewer.Winner.WinnerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.*;

public class WinnerViewerTest {
    private GUI mockgui;
    private Winner mockWinner;
    WinnerViewer winnerViewer;

    @BeforeEach
    public void setup(){
        mockgui = Mockito.mock(GUI.class);
        mockWinner = Mockito.mock(Winner.class);
        winnerViewer = new WinnerViewer(mockWinner);
    }

    @Test
    public void testDrawSymbol(){
        winnerViewer.drawSymbol(mockgui);
        Mockito.verify(mockgui,Mockito.times(10)).drawText(any(Position.class),anyString(),anyString());
    }

    @Test
    public void testDrawElements(){
        Mockito.when(mockWinner.getPlaynumber()).thenReturn(1);
        Mockito.when(mockWinner.getNumberEntries()).thenReturn(2);
        Mockito.when(mockWinner.isSelected(anyInt())).thenReturn(true);

        winnerViewer.drawElements(mockgui);
        Mockito.verify(mockgui,Mockito.times(11)).drawText(any(Position.class),anyString(),anyString());
    }


}
