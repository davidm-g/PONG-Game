package com.aor.pong.Controller;

import com.aor.pong.Game;
import com.aor.pong.controller.MusicManager;
import com.aor.pong.controller.menu.MenuController;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.states.GameState;
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
        Mockito.verify(mockGame, Mockito.times(1)).setState(Mockito.any(GameState.class));
    }
}