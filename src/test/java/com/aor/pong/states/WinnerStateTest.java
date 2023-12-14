package com.aor.pong.states;

import com.aor.pong.controller.Controller;
import com.aor.pong.controller.Winner.WinnerController;
import com.aor.pong.controller.game.ArenaController;
import com.aor.pong.model.Winner.Winner;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.viewer.Viewer;
import com.aor.pong.viewer.Winner.WinnerViewer;
import com.aor.pong.viewer.game.GameViewer;
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
