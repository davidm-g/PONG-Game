package com.pong;

import com.pong.gui.LanternaGUI;
import com.pong.states.MenuState;
import com.pong.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setup() throws IOException, URISyntaxException, FontFormatException {
        game = Mockito.spy(new Game());
    }

    @Test
    public void testInitialState(){
        State initialState = game.getState();
        assertEquals(MenuState.class,initialState.getClass());
    }

    @Test
    public void testSetState(){
        State newState = Mockito.mock(State.class);
        game.setState(newState);

        State currentState = game.getState();
        assertEquals(newState,currentState);
    }

    @Test
    public void testGameLoop() throws IOException {
        LanternaGUI guimock = Mockito.mock(LanternaGUI.class);
        State statemock = Mockito.mock(State.class);

        Mockito.when(game.getState()).thenReturn(statemock);
        Mockito.doNothing().when(statemock).step(Mockito.any(Game.class),Mockito.any(LanternaGUI.class),Mockito.anyLong());
        Mockito.doNothing().when(guimock).close();


    }


}
