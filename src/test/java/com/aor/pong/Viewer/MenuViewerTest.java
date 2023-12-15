package com.aor.pong.Viewer;

import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.model.mode.Mode;
import com.aor.pong.viewer.menu.MenuViewer;
import com.aor.pong.viewer.mode.ModeViewer;
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

        Mockito.verify(mockGUI).drawText(new Position(5,3),"    ____  ____  _   ________","#FFB852");
        Mockito.verify(mockGUI).drawText(new Position(5,4),"   / __ \\/ __ \\/ | / / ____/","#FFB852");
        Mockito.verify(mockGUI).drawText(new Position(5,5),"  / /_/ / / / /  |/ / /","#FFB852");
        Mockito.verify(mockGUI).drawText(new Position(5,6)," / ____/ /_/ / /|  / /_/ /","#FFB852");
        Mockito.verify(mockGUI).drawText(new Position(5,7),"/_/    \\____/_/ |_/\\____/","#FFB852");

    }

    @Test
    public void testDrawElements(){

        Mockito.when(mockMenu.getNumberEntries()).thenReturn(2);
        Mockito.when(mockMenu.getEntry(0)).thenReturn("Play");
        Mockito.when(mockMenu.getEntry(1)).thenReturn("Leave Game");
        Mockito.when(mockMenu.isSelected(0)).thenReturn(true);
        Mockito.when(mockMenu.isSelected(1)).thenReturn(false);

        ;

        menuViewer.drawElements(mockGUI);

        menuViewer.drawSymbol(mockGUI);


        Mockito.verify(mockGUI).drawText(new Position(5,11),"Play","#38b7fe");
        Mockito.verify(mockGUI).drawText(new Position(5,13),"Leave Game","#FFFFFF");


    }
}
