package com.pong.Controller;

import com.pong.Game;
import com.pong.controller.mode.ModeController;
import com.pong.gui.GUI;
import com.pong.model.mode.Mode;
import com.pong.states.GameState;
import com.pong.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ModeControllerTest {
    private ModeController modeController;
    private Mode mockmode;
    private Game mockGame;

    @BeforeEach
    void setUp() {
        mockmode = Mockito.mock(Mode.class);
        modeController = new ModeController(mockmode);
        mockGame = Mockito.mock(Game.class);
    }
    @Test
    void testQuitAction() throws IOException {
        Mockito.when(mockmode.isSelectedEasy()).thenReturn(false);
        Mockito.when(mockmode.isSelectedMedium()).thenReturn(false);
        Mockito.when(mockmode.isSelectedHard()).thenReturn(false);

        modeController.step(mockGame, GUI.ACTION.QUIT,0);

        Mockito.verify(mockGame,Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

    @Test
    void testPaddle2UpAction() throws IOException {
        Mockito.when(mockmode.isSelectedEasy()).thenReturn(false);
        Mockito.when(mockmode.isSelectedMedium()).thenReturn(false);
        Mockito.when(mockmode.isSelectedHard()).thenReturn(false);

        modeController.step(mockGame, GUI.ACTION.PADDLE2UP, 0);

        Mockito.verify(mockmode, Mockito.times(1)).previousEntry();
    }

    @Test
    void testPaddle2DownAction() throws IOException {
        Mockito.when(mockmode.isSelectedEasy()).thenReturn(false);
        Mockito.when(mockmode.isSelectedMedium()).thenReturn(false);
        Mockito.when(mockmode.isSelectedHard()).thenReturn(false);

        modeController.step(mockGame, GUI.ACTION.PADDLE2DOWN, 0);

        Mockito.verify(mockmode, Mockito.times(1)).nextEntry();
    }

    @Test
    void testSelectEasy() throws IOException {
        Mockito.when(mockmode.isSelectedEasy()).thenReturn(true);
        Mockito.when(mockmode.isSelectedMedium()).thenReturn(false);
        Mockito.when(mockmode.isSelectedHard()).thenReturn(false);

        modeController.step(mockGame, GUI.ACTION.SELECT, 0);
        Mockito.verify(mockmode, Mockito.times(1)).isSelectedEasy();
        Mockito.verify(mockGame, Mockito.times(1)).setState(Mockito.any(GameState.class));
    }

    @Test
    void testSelectMedium() throws IOException {
        Mockito.when(mockmode.isSelectedMedium()).thenReturn(true);
        Mockito.when(mockmode.isSelectedHard()).thenReturn(false);
        Mockito.when(mockmode.isSelectedEasy()).thenReturn(false);

        modeController.step(mockGame, GUI.ACTION.SELECT, 0);

        Mockito.verify(mockmode, Mockito.times(1)).isSelectedMedium();
        Mockito.verify(mockGame, Mockito.times(1)).setState(Mockito.any(GameState.class));
    }

    @Test
    void testSelectHard() throws IOException {
        Mockito.when(mockmode.isSelectedMedium()).thenReturn(false);
        Mockito.when(mockmode.isSelectedHard()).thenReturn(true);
        Mockito.when(mockmode.isSelectedEasy()).thenReturn(false);

        modeController.step(mockGame, GUI.ACTION.SELECT, 0);

        Mockito.verify(mockmode, Mockito.times(1)).isSelectedHard();
        Mockito.verify(mockGame, Mockito.times(1)).setState(Mockito.any(GameState.class));
    }


}
