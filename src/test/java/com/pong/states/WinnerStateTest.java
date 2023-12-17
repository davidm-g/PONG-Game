package com.pong.states;

import com.pong.controller.Controller;
import com.pong.controller.Winner.WinnerController;
import com.pong.model.Winner.Winner;
import com.pong.viewer.Viewer;
import com.pong.viewer.Winner.WinnerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerStateTest {
    private Winner winnermock;
    private WinnerState winnerState;

    @BeforeEach
    public void setup(){
        winnermock = Mockito.mock(Winner.class);
        winnerState = new WinnerState(winnermock);
    }
    @Test
    public void testGetViewer(){
        Viewer<Winner> viewer = winnerState.getViewer();
        assertEquals(WinnerViewer.class,viewer.getClass());
    }
    @Test
    public void testGetController(){
        Controller<Winner> controller = winnerState.getController();
        assertEquals(WinnerController.class,controller.getClass());
    }
}
