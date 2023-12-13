package com.aor.pong.Controller;

import com.aor.pong.Game;
import com.aor.pong.controller.Music;
import com.aor.pong.controller.MusicManager;
import com.aor.pong.controller.Sounds;
import com.aor.pong.controller.Winner.WinnerController;
import com.aor.pong.controller.menu.MenuController;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.Winner.Winner;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.states.GameState;
import com.aor.pong.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

public class WinnerControllerTest {
    private WinnerController winnerController;
    private Winner mockWinner;
    private Game mockGame;


    @BeforeEach
    void setUp() {
        mockWinner = Mockito.mock(Winner.class);
        winnerController = new WinnerController(mockWinner);
        mockGame = Mockito.mock(Game.class);


    }

    @Test
    void testPaddle2UpAction() throws IOException {
        Mockito.when(mockWinner.isSelectedMenu()).thenReturn(false);
        Mockito.when(mockWinner.isSelectedPlay()).thenReturn(false);

        winnerController.step(mockGame, GUI.ACTION.PADDLE2UP, 0);

        Mockito.verify(mockWinner, Mockito.times(1)).previousEntry();
    }

    @Test
    void testPaddle2DownAction() throws IOException {
        Mockito.when(mockWinner.isSelectedMenu()).thenReturn(false);
        Mockito.when(mockWinner.isSelectedPlay()).thenReturn(false);

        winnerController.step(mockGame, GUI.ACTION.PADDLE2DOWN, 0);

        Mockito.verify(mockWinner, Mockito.times(1)).nextEntry();
    }
    @Test
    public void testSelectMenu() throws IOException {
        Mockito.when(mockWinner.isSelectedMenu()).thenReturn(true);
        winnerController.step(mockGame, GUI.ACTION.SELECT,0);
        Mockito.verify(mockWinner,Mockito.times(1)).isSelectedMenu();
        Mockito.verify(mockGame,Mockito.times(1)).setState(any(MenuState.class));


    }
    @Test
    public void testSelectPlay() throws IOException {
        Mockito.when(mockWinner.isSelectedPlay()).thenReturn(true);
        winnerController.step(mockGame, GUI.ACTION.SELECT,0);
        Mockito.verify(mockWinner,Mockito.times(1)).isSelectedPlay();
        Mockito.verify(mockGame,Mockito.times(1)).setState(any(GameState.class));
    }

}
