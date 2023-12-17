package com.pong.Controller;

import com.pong.Game;
import com.pong.controller.menu.MenuController;
import com.pong.gui.GUI;
import com.pong.model.menu.Menu;
import com.pong.states.ModeState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuControllerTest {
    private MenuController menuController;
    private Menu mockMenu;
    private Game mockGame;

    @BeforeEach
    void setUp() {
        mockMenu = Mockito.mock(Menu.class);
        menuController = new MenuController(mockMenu);
        mockGame = Mockito.mock(Game.class);
    }

    @Test
    void testPaddle2UpAction() throws IOException {
        Mockito.when(mockMenu.isSelectedLeave()).thenReturn(false);
        Mockito.when(mockMenu.isSelectedPlay()).thenReturn(false);

        menuController.step(mockGame, GUI.ACTION.PADDLE2UP, 0);

        Mockito.verify(mockMenu, Mockito.times(1)).previousEntry();
    }

    @Test
    void testPaddle2DownAction() throws IOException {
        Mockito.when(mockMenu.isSelectedLeave()).thenReturn(false);
        Mockito.when(mockMenu.isSelectedPlay()).thenReturn(false);

        menuController.step(mockGame, GUI.ACTION.PADDLE2DOWN, 0);

        Mockito.verify(mockMenu, Mockito.times(1)).nextEntry();
    }

    @Test
    void testSelectLeave() throws IOException {
        Mockito.when(mockMenu.isSelectedLeave()).thenReturn(true);

        menuController.step(mockGame, GUI.ACTION.SELECT, 0);

        Mockito.verify(mockGame, Mockito.times(1)).setState(null);
    }

    @Test
    void testSelectPlay() throws IOException {
        Mockito.when(mockMenu.isSelectedLeave()).thenReturn(false);
        Mockito.when(mockMenu.isSelectedPlay()).thenReturn(true);

        menuController.step(mockGame, GUI.ACTION.SELECT, 0);

        Mockito.verify(mockMenu, Mockito.times(1)).isSelectedPlay();
        Mockito.verify(mockGame, Mockito.times(1)).setState(Mockito.any(ModeState.class));
    }
}