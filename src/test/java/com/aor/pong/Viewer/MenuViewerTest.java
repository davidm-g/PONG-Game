package com.aor.pong.Viewer;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.viewer.menu.MenuViewer;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;

public class MenuViewerTest {
    private Menu mockMenu;
    private MenuViewer menuViewer;
    private GUI mockGUI;

    @BeforeEach
    public void setup(){
        mockMenu = Mockito.mock(Menu.class);
        menuViewer = new MenuViewer(mockMenu);
        mockGUI = Mockito.mock(GUI.class);
    }

    @Test
    public void testDrawSymbol(){

        menuViewer.drawSymbol(mockGUI);

        Mockito.verify(mockGUI,Mockito.times(5)).drawText(Mockito.any(Position.class),Mockito.anyString(),Mockito.anyString());

    }

    @Test

    public void testDrawElements(){
        menuViewer.drawElements(mockGUI);
        Mockito.when(mockMenu.getNumberEntries()).thenReturn(2);
        Mockito.when(mockMenu.isSelected(anyInt())).thenReturn(true);

        Mockito.verify(mockGUI,Mockito.times(5)).drawText(any(Position.class),anyString(),anyString());
    }
}
